package com.example.EmailIntegrationByJavaMailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailIntegrationByJavaMailSenderApplication {
	@Autowired
	private EmailSenderService senderService;
	public static void main(String[] args) {
		SpringApplication.run(EmailIntegrationByJavaMailSenderApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws Exception {
		senderService.sendSimpleEmail("kashifnezam123@gmail.com",
				"This is email body",
				"hi kashif i am atul");

	}

}
