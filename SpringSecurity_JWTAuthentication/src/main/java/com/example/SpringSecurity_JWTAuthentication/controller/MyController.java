package com.example.SpringSecurity_JWTAuthentication.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/home")
//    @PreAuthorize("hasRole('ROLE_USER')")    //@Secured ({"ROLE_USER"})        //2way for adding restriction using  @method based security annotation on configuration class
    public String home(){
        return "home";
    }
}
