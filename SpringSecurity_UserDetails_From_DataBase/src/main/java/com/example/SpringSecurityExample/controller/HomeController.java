package com.example.SpringSecurityExample.controller;

import com.example.SpringSecurityExample.model.User;
import com.example.SpringSecurityExample.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
       @Autowired
      private LoginService loginService;
    @GetMapping("/home")
    public String welcome()
    {
        return "welcome";
    }
    @PostMapping("/save")
    public ResponseEntity<?> Save(@RequestBody User user)
    {
        System.out.println(user.getUserName()+"   ---"+user.getPassword());
        return ResponseEntity.ok(loginService.saveIntoDb(user));
//        return "sucessfully save into DB";
    }
}
