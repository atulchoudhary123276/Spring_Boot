package com.example.EmployeeCrud1.service;

import com.example.EmployeeCrud1.dto.EmployeeDto;
import com.example.EmployeeCrud1.model.EmployeeModel;
import com.example.EmployeeCrud1.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
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
        return convertToDtoList(employeeRepository.findAll());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
       return employeeRepository.findById(id).
            map(this::convertToDto).orElse(null);
    }

    @Override
    public EmployeeDto updateEmployeeById(Long id, EmployeeDto employee) {
        return employeeRepository.findById(id)
                .map(employeeModel -> {
                    employeeModel.setFirstName(employee.getFirstName());
                    employeeModel.setLastName(employee.getLastName());
                    employeeModel.setAddress(employee.getAddress());
                    employeeModel.setCity(employee.getCity());
                    employeeModel.setPincode(employee.getPincode());
                    //update existing resource
                    return convertToDto(employeeRepository.save(employeeModel));
                })
                //create new resource when it not exists
                .orElseGet(()-> convertToDto(employeeRepository.save(convertToModel(employee))));
    }

    @Override
    public EmployeeDto updateEmployeePartiallyById(Long id, Map<String, Object> fields) {
        return employeeRepository.findById(id)
                .map(employeeModel -> {
                    for (Map.Entry<String, Object> entry : fields.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        switch (key) {
                            case "firstName":
                                employeeModel.setFirstName(value.toString());
                                break;
                            case "lastName":
                                employeeModel.setLastName(value.toString());
                                break;
                            case "address":
                                employeeModel.setAddress(value.toString());
                                break;
                            case "city":
                                employeeModel.setCity(value.toString());
                                break;
                            case "pincode":
                                employeeModel.setPincode((Integer) value);
                                break;
                            default:
                                // handle unknown keys
                                return null;
                        }
                    }
                    // update resource fields only if all keys were recognized
                    return convertToDto(employeeRepository.save(employeeModel));

                })
                .orElse(null);  //return null if resource not exist
    }

    @Override
    public boolean deleteEmployeeById(Long id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public boolean existById(Long id){
        return employeeRepository.existsById(id);
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
