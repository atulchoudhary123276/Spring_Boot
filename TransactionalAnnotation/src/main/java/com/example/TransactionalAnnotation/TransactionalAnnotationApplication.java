package com.example.TransactionalAnnotation;

import com.example.TransactionalAnnotation.model.Address;
import com.example.TransactionalAnnotation.model.Employee;
import com.example.TransactionalAnnotation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionalAnnotationApplication {

	public static void main(String[] args) {
	SpringApplication.run(TransactionalAnnotationApplication.class, args);


	}

}
