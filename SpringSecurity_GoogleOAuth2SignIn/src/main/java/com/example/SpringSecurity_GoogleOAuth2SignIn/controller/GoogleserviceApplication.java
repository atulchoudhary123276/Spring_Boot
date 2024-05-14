package com.example.SpringSecurity_GoogleOAuth2SignIn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GoogleserviceApplication {
    @RequestMapping(value = "/user")
    public Principal user(Principal principal) {
        return principal;
    }
    @GetMapping("/welcome")
    public String gotoWelcome(){
        return "Welcome to Home Page";
    }
}
