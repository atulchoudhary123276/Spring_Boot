package com.example.SpringBatch_Processing_csvToDB.repository;

import com.example.SpringBatch_Processing_csvToDB.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
