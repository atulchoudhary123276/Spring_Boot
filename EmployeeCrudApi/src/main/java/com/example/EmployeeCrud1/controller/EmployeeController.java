package com.example.EmployeeCrud1.controller;

import com.example.EmployeeCrud1.dto.EmployeeDto;
import com.example.EmployeeCrud1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //create new resource if it is not exist ,otherwise replace(update) existing  resource
    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody @Validated EmployeeDto employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.saveEmployee(employee));
    }

    //get all employees from DB
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employeeDtoList = employeeService.fetchAllEmployees();
        if (employeeDtoList.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(employeeDtoList));
    }

    //get employee list by id
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        EmployeeDto employeeById = employeeService.getEmployeeById(id);
        if (employeeById != null) {
            return ResponseEntity.status(HttpStatus.OK).body(employeeById);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //update resource all fields by id if exist ,otherwise create new resource
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody @Validated EmployeeDto employee) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(id, employee));
    }

    //update resource partially  by id
    @PatchMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployeePartially(@PathVariable("id") Long id, @RequestBody EmployeeDto employee) {
        EmployeeDto employeeDto = employeeService.updateEmployeePartiallyById(id, employee);
        if (employeeDto != null) {
            return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //delete resource by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        if (employeeService.deleteEmployeeById(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not Found");
        }
    }
}
