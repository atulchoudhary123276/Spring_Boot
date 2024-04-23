package com.example.SpringSecurity_InMemoryUserValidation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/")
    public String  getHome(){
        return "Welcome to Home page of spring security";
    }
}
