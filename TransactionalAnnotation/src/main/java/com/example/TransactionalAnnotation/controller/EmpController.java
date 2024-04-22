package com.example.TransactionalAnnotation.controller;

import com.example.TransactionalAnnotation.model.Address;
import com.example.TransactionalAnnotation.model.Employee;
import com.example.TransactionalAnnotation.service.AddressService;
import com.example.TransactionalAnnotation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class EmpController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AddressService addressService;

    @GetMapping("/emp")
    public String addEmp(){
        Employee employee=new Employee();
        employee.setFirstName("ramu");
        employee.setLastName("kumar");
        employeeService.addEmployeeToDb(employee);
        return "emp and address added successfully";
    }
    @GetMapping("/address")
    public String addAddress(){
        addressService.addAddress(new Address("Gzb"));
        return "Only address added sucessfully";
    }

    @GetMapping("emp/{id}")
    public String updateEmployee(@PathVariable String id){
        return employeeService.updateEmp(id);
    }

    @GetMapping("/getEmp/{id}")
    public Employee getEmp1(@PathVariable String  id)
    {
        return employeeService.getEmployee(id);

    }

    @GetMapping("remove/{id}")
    public String deleteEmployee(@PathVariable String id){
        employeeService.removeEmp(id);
        return "deleted";
    }

    @GetMapping("/allEmp")
    public ResponseEntity<?> getAllEmp(){
        return ResponseEntity.ok().body(employeeService.fetchEmployees());
    }

    @GetMapping("/join")
    public ResponseEntity<?> getJoinResult(){
        return ResponseEntity.ok().body(employeeService.getJoinResult());
    }
}
