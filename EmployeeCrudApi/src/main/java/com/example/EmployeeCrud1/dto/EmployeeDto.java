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
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String address;
    @NotEmpty
    private String city;
    @NotNull
    private Integer pincode;
}
