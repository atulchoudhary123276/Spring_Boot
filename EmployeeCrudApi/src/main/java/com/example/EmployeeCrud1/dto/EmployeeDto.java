package com.example.EmployeeCrud1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {
    private Long empId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String pincode;
}
