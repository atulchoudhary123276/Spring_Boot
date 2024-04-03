package com.example.EmployeeCrud1.service;

import com.example.EmployeeCrud1.dto.EmployeeDto;
import com.example.EmployeeCrud1.model.EmployeeModel;
import com.example.EmployeeCrud1.repository.EmployeeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    UtilityService utilityService;

    // For creating an Employee (Create)
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employee) {
        return utilityService.convertToDto(employeeRepository.save(utilityService.convertToModel(employee)));
    }

    //Get  AllEmployees
    @Override
    public List<EmployeeDto> fetchAllEmployees() {
        return utilityService.convertToDtoList(employeeRepository.findAll());

    }

    //Get  Employee by id (Read)
    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return employeeRepository.findById(id).
                map(employeeModel -> utilityService.convertToDto(employeeModel))
                .orElse(null);
    }

    //Update Employee AllResource by Id (Update)
    @Override
    public EmployeeDto updateEmployeeById(Long id, EmployeeDto employee) {
        Optional<EmployeeModel> emp = employeeRepository.findById(id);
        if (emp.isEmpty()) {
            //create resource if it not exists
            return saveEmployee(employee);
        }
        //update all existing resource
        EmployeeModel employeeModel = emp.get();
        employeeModel.setPincode(employee.getPincode());
        employeeModel.setCity(employee.getCity());
        employeeModel.setFirstName(employee.getFirstName());
        employeeModel.setAddress(employee.getAddress());
        employeeModel.setLastName(employee.getLastName());
        return utilityService.convertToDto(employeeRepository.save(employeeModel));
    }

    //Update Employee Resource by Id (PartiallyUpdate)
    @Override
    public Object updateEmployeePartiallyById(Long id, EmployeeDto employeeDto) {
        Optional<EmployeeModel> employeeModelOptional = employeeRepository.findById(id);
        if(employeeModelOptional.isPresent()){
            boolean updated=false;
            List<String> errorList=new ArrayList<>();
            EmployeeModel employeeModel=employeeModelOptional.get();
            if(employeeDto.getFirstName()!=null) {
                if (StringUtils.isNotBlank(employeeDto.getFirstName()))
                    employeeModel.setFirstName(employeeDto.getFirstName());
                else
                    errorList.add("firstName can't be empty");
            }
            if(employeeDto.getLastName()!=null) {
                if (StringUtils.isNotBlank(employeeDto.getLastName()))
                    employeeModel.setLastName(employeeDto.getLastName());
                else
                    errorList.add("lastName can't be empty");
            }
            if(employeeDto.getAddress()!=null){
                if(StringUtils.isNotBlank(employeeDto.getAddress()))
                    employeeModel.setAddress(employeeDto.getAddress());
                else
                    errorList.add("address can't be empty");
            }
            if(employeeDto.getCity()!=null){
                if(StringUtils.isNotBlank(employeeDto.getCity()))
                    employeeModel.setAddress(employeeDto.getCity());
                else
                    errorList.add("city can't be empty");
            }
            if(employeeDto.getPincode()!=null){
                if(StringUtils.isNotBlank(employeeDto.getPincode()))
                    employeeModel.setPincode(employeeDto.getPincode());
                else
                    errorList.add("pincode can't be empty");
            }
            if(errorList.isEmpty())
                return utilityService.convertToDto(employeeRepository.save(employeeModel));
            return errorList;
        }
        return null;


    }

    //delete Employee by Id
    @Override
    public boolean deleteEmployeeById(Long id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return employeeRepository.existsById(id);
    }
}
