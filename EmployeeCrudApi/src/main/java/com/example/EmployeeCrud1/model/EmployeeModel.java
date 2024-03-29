package com.example.EmployeeCrud1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "emp",uniqueConstraints =
        { @UniqueConstraint(name = "empId", columnNames = { "empId" })})
@Getter
@Setter
@NoArgsConstructor
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
//    @NotEmpty
//    private String empId;
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
