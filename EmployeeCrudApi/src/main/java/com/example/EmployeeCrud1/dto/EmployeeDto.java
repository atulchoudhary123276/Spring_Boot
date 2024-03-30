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
    @NotEmpty(message = "firstName is not Empty")
    private String firstName;
    @NotEmpty(message = "lastName is not Empty")
    private String lastName;
    @NotEmpty(message = "address is not Empty")
    private String address;
    @NotEmpty(message = "city is not Empty")
    private String city;
    @NotNull(message = "pincode is not Empty")
    private Integer pincode;
}
