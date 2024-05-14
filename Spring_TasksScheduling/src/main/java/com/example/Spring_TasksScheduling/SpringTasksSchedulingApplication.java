package com.example.Spring_TasksScheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling   //for enabling the schedulers
public class SpringTasksSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTasksSchedulingApplication.class, args);
	}

}
