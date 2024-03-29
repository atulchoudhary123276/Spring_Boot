package com.example.EmployeeCrud1.repository;

import com.example.EmployeeCrud1.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel,Long> {
}
