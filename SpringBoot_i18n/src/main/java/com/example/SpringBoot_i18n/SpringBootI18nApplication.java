package com.example.SpringBoot_i18n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
public class SpringBootI18nApplication {
	public static Map<String, Locale> languageMap=new HashMap<>();
	public static void main(String[] args) {
		SpringApplication.run(SpringBootI18nApplication.class, args);
		languageMap.put("setlang",Locale.US);
	}

}
