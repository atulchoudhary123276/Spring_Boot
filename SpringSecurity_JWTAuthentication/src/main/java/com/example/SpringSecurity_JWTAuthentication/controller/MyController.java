package com.example.SpringSecurity_JWTAuthentication.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;

@Controller
public class MyController {
             //authenticated
    @GetMapping("/home")
//    @PreAuthorize("hasRole('ROLE_USER')")    //@Secured ({"ROLE_USER"})        //2way for adding restriction using  @method based security annotation on configuration class
    public String home(){
        return "home";
    }
    @GetMapping("/form")
    public String toLogin(){
        return "loginPage";
    }
}
