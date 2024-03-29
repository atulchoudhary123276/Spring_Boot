package com.example.EmployeeCrud1.service;

import com.example.EmployeeCrud1.dto.EmployeeDto;
import com.example.EmployeeCrud1.model.EmployeeModel;
import com.example.EmployeeCrud1.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employee) {
        return convertToDto(employeeRepository.save(convertToModel(employee)));
    }

    @Override
    public List<EmployeeDto> fetchAllEmployees() {
        List<EmployeeModel> allEmployees = employeeRepository.findAll();
        return convertToDtoList(allEmployees);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Optional<EmployeeModel> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return convertToDto(employee.get());
        }
        return null;
    }

    @Override
    public EmployeeDto updateEmployeeById(Long id, EmployeeDto employee) {
        Optional<EmployeeModel> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            EmployeeModel originalEmployee = employeeOptional.get();
            originalEmployee.setFirstName(employee.getFirstName());
            originalEmployee.setLastName(employee.getLastName());
            originalEmployee.setAddress(employee.getAddress());
            originalEmployee.setCity(employee.getCity());
            originalEmployee.setPincode(employee.getPincode());
            //update existing resource
            return convertToDto(employeeRepository.save(originalEmployee));
        }
        else {
            //create new resource
            return convertToDto(employeeRepository.save(convertToModel(employee)));
        }

    }

    @Override
    public EmployeeDto updateEmployeePartiallyById(Long id, EmployeeDto employee) {
        Optional<EmployeeModel> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            EmployeeModel originalEmployee = employeeOptional.get();

            // Update fields if provided in the DTO

            if (Objects.nonNull(employee.getFirstName()) && !employee.getFirstName().isEmpty()) {
                originalEmployee.setFirstName(employee.getFirstName());
                return convertToDto(employeeRepository.save(originalEmployee));
            }
            if (Objects.nonNull(employee.getLastName()) && !employee.getLastName().isEmpty()) {
                originalEmployee.setLastName(employee.getLastName());
                return convertToDto(employeeRepository.save(originalEmployee));
            }
            if (Objects.nonNull(employee.getAddress()) && !employee.getAddress().isEmpty()) {
                originalEmployee.setAddress(employee.getAddress());
                return convertToDto(employeeRepository.save(originalEmployee));
            }
            if (Objects.nonNull(employee.getCity()) && !employee.getCity().isEmpty()) {
                originalEmployee.setCity(employee.getCity());
                return convertToDto(employeeRepository.save(originalEmployee));
            }
            if (Objects.nonNull(employee.getPincode())) {
                originalEmployee.setPincode(employee.getPincode());
                return convertToDto(employeeRepository.save(originalEmployee));
            }
            // return if field not found
            return null;

        }
        //if resource not found
        return null;
    }

    @Override
    public boolean deleteEmployeeById(Long id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private EmployeeDto convertToDto(EmployeeModel employeeModel) {
        return modelMapper.map(employeeModel, EmployeeDto.class);
    }

    private List<EmployeeDto> convertToDtoList(List<EmployeeModel> employeeModelList) {
        return employeeModelList.stream()
                .map(employeeModel -> modelMapper.map(employeeModel, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    private EmployeeModel convertToModel(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, EmployeeModel.class);
    }

}
