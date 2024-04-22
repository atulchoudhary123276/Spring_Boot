package com.example.TransactionalAnnotation.repository;

import com.example.TransactionalAnnotation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Employee,Long> {
}
