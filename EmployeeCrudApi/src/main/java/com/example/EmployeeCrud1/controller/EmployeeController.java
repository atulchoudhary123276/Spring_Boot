package com.example.EmployeeCrud1.controller;

import com.example.EmployeeCrud1.dto.EmployeeDto;
import com.example.EmployeeCrud1.service.EmployeeService;
import com.example.EmployeeCrud1.service.UtilityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UtilityService utilityService;

    //create new resource if it is not exist ,otherwise replace(update) existing  resource
    @PostMapping("/create")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDto employee) {
        List<String> errorMsgList = utilityService.isDtoContainsAllField(employee);
        if (CollectionUtils.isEmpty(errorMsgList)) {
            EmployeeDto employeeDto = employeeService.saveEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(employeeDto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsgList);
    }

    //get all employees from DB
    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
        List<EmployeeDto> employeeDtoList = employeeService.fetchAllEmployees();
        if (CollectionUtils.isEmpty(employeeDtoList)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employees not exist");
        }
        return ResponseEntity.of(Optional.of(employeeDtoList));
    }

    //get employee list by id
    @GetMapping("{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id) {
        EmployeeDto employeeById = employeeService.getEmployeeById(id);
        if (Objects.nonNull(employeeById)) {
            return ResponseEntity.status(HttpStatus.OK).body(employeeById);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not exist at this " + id + "  id");
        }
    }

    //update resource all fields by id if exist ,otherwise create new resource
    @PutMapping("{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employee) {
        List<String> errorMsgList = utilityService.isDtoContainsAllField(employee);
        if (!employeeService.existById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee not exists");
        } else if (CollectionUtils.isEmpty(errorMsgList)) {
            EmployeeDto emp = employeeService.updateEmployeeById(id, employee);
            return ResponseEntity.status(HttpStatus.OK).body(emp);

        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsgList);
        }

    }

    //update resource partially  by id
    @PatchMapping("{id}")
    public ResponseEntity<?> updateEmployeePartially(@PathVariable("id") Long id, @RequestBody EmployeeDto employee) {
        Object employeeDto = employeeService.updateEmployeePartiallyById(id, employee);
        if (Objects.nonNull(employeeDto)) {
            return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
        } else if (employeeService.existById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Field not exist");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Not Found ");
        }
    }

    //delete resource by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        if (employeeService.deleteEmployeeById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body("Resource deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not exist at " + id + " id for deletion");
        }
    }
}
