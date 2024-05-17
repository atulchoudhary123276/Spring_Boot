package com.example.SpringBatch_Processing_csvToDB.config;

import com.example.SpringBatch_Processing_csvToDB.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer,Customer> {

    @Override
    public Customer process(Customer customer) throws Exception {
//        if(customer.getCountry().equals("United States")) {
//            return customer;
//        }else{
//            return null;
//        }
        return customer;
    }
}