package com.example.SpringSecurity_JWTAuthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityJwtAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtAuthenticationApplication.class, args);
	}

}
