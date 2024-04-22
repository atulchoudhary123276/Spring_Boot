package com.example.TransactionalAnnotation.repository;

import com.example.TransactionalAnnotation.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
