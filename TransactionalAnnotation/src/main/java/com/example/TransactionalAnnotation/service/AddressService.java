package com.example.TransactionalAnnotation.service;

import com.example.TransactionalAnnotation.model.Address;
import com.example.TransactionalAnnotation.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Address addAddress(Address address){
        return addressRepository.save(address);
    }

}
