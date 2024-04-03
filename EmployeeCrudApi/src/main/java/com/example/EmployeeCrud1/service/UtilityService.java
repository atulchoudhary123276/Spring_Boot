package com.example.EmployeeCrud1.service;

import com.example.EmployeeCrud1.dto.EmployeeDto;
import com.example.EmployeeCrud1.model.EmployeeModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UtilityService {
    EmployeeDto convertToDto(EmployeeModel employeeModel);
    List<EmployeeDto> convertToDtoList(List<EmployeeModel> employeeModelList);
    EmployeeModel convertToModel(EmployeeDto employeeDto);
    List<String> isDtoContainsAllField(EmployeeDto employeeDto);
}
