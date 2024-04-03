package com.example.EmployeeCrud1.service;

import com.example.EmployeeCrud1.dto.EmployeeDto;
import com.example.EmployeeCrud1.model.EmployeeModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UtilityServiceImpl implements UtilityService {

    @Override
    public EmployeeDto convertToDto(EmployeeModel employeeModel) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmpId(employeeModel.getEmpId());
        employeeDto.setFirstName( employeeModel.getFirstName());
        employeeDto.setLastName(employeeModel.getLastName());
        employeeDto.setAddress(employeeModel.getAddress());
        employeeDto.setCity(employeeModel.getCity());
        employeeDto.setPincode(employeeModel.getPincode());

        return employeeDto;
    }
    @Override
    public List<EmployeeDto> convertToDtoList(List<EmployeeModel> employeeModels) {
        if (CollectionUtils.isEmpty(employeeModels)) {
            return null;
        }
        return employeeModels.stream()
                .map(this::convertToDto) // Convert each EmployeeModel to EmployeeDto
                .collect(Collectors.toList()); // Collect the non-null EmployeeDto objects into a list
    }

    @Override
    public EmployeeModel convertToModel(EmployeeDto employeeDto) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setFirstName(employeeDto.getFirstName());
        employeeModel.setLastName(employeeDto.getLastName());
        employeeModel.setAddress(employeeDto.getAddress());
        employeeModel.setCity(employeeDto.getCity());
        employeeModel.setPincode(employeeDto.getPincode());

        return employeeModel;
    }

    @Override
    public List<String> isDtoContainsAllField(EmployeeDto employee) {
        List<String> errorMsgList=new ArrayList<>();
        if (StringUtils.isBlank(employee.getFirstName()))
            errorMsgList.add("First Name Can't be empty.");
        if (StringUtils.isBlank(employee.getLastName()))
            errorMsgList.add("Last Name Can't be empty.");
        if (StringUtils.isBlank(employee.getCity()))
            errorMsgList.add("City  Can't be empty.");
        if (StringUtils.isBlank(employee.getAddress()))
            errorMsgList.add("Address Can't be empty.");
        if (StringUtils.isBlank(employee.getPincode()))
            errorMsgList.add("Pincode Can't be empty.");
        return errorMsgList;
    }

}
