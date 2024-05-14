package com.example.SpringSecurity_GoogleOAuth2SignIn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class SpringSecurityGoogleOAuth2SignInApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityGoogleOAuth2SignInApplication.class, args);
	}

}
