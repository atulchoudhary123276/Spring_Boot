package com.example.TransactionalAnnotation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter          //parent
@NamedQuery(
        query = "FROM Employee",
        name = "Emp.FindAll"
)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName,lastName;

    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
    private Address address;

    @Override
    public String toString() {
        return "Employee{" +
                "address=" + address +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
