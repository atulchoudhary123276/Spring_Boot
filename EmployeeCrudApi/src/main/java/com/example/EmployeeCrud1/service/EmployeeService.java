package com.example.EmployeeCrud1.service;

import com.example.EmployeeCrud1.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employee);

    List<EmployeeDto> fetchAllEmployees();

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto updateEmployeeById(Long id, EmployeeDto employee);

    boolean deleteEmployeeById(Long id);
    EmployeeDto updateEmployeePartiallyById(Long id, EmployeeDto employee);

}
