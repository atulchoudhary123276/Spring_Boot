package com.example.TransactionalAnnotation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor     //child
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long addressId;
    String city;

    @OneToOne
    @JsonIgnore
    private Employee employee;

    public Address(String city) {
        this.city = city;
    }
    public Address(String city,Employee employee) {
        this.city = city;
        this.employee=employee;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +            //remove  employee reference for ignoring  circular dependency
                '}';
    }
}
