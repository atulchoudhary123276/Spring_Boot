package com.example.SpringBoot_i18n.controller;

import com.example.SpringBoot_i18n.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static com.example.SpringBoot_i18n.SpringBootI18nApplication.languageMap;

@RestController
public class MyController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/changeLanguage")
    public ResponseEntity<?> changeLanguage(@RequestParam String language){
      return ResponseEntity.ok(languageMap.put("setlang", Locale.forLanguageTag(language)));

    }

    @GetMapping("/message")
    public ResponseEntity<?> getMessage(HttpServletRequest request) {
//        Locale locale = LocaleContextHolder.getLocale();
        Locale locale=languageMap.get("setlang");
        ApiResponse response = new ApiResponse();
        response.setMessage(messageSource.getMessage("message_name", null, locale));
        response.setLocale(String.valueOf(locale));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/country")
    public ResponseEntity<?> getNameOfCountry(HttpServletRequest request) {
//        Locale locale = LocaleContextHolder.getLocale();
        Locale locale=languageMap.get("setlang");
        ApiResponse response = new ApiResponse();
        response.setCountry(messageSource.getMessage("name", null, locale));
        response.setLocale(String.valueOf(locale));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/currency")
    public ResponseEntity<?> getNameOfCurrency(HttpServletRequest request) {
//        Locale locale = LocaleContextHolder.getLocale();
        Locale locale=languageMap.get("setlang");
        ApiResponse response = new ApiResponse();
        response.setCountry(messageSource.getMessage("currency", null, locale));
        response.setLocale(String.valueOf(locale));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/open")
    private String getOpenMessage() {
        return "This is Open message for all ";
    }

}
