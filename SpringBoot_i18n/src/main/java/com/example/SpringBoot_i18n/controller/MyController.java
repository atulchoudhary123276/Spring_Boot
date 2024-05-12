package com.example.SpringBoot_i18n.controller;

import com.example.SpringBoot_i18n.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RestController
public class MyController {
    @Autowired
    MessageSource messageSource;
    @GetMapping("/home")
    public ApiResponse home(){
        Locale locale = LocaleContextHolder.getLocale();

        ApiResponse response =new ApiResponse();
        response.setMessage(messageSource.getMessage("title",null,locale));
        response.setLocale(String.valueOf(locale));
            return  response;
    }
}
