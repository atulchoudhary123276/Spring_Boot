package com.example.SpringSecurity_JWTAuthentication.controller;

import com.example.SpringSecurity_JWTAuthentication.helper.JwtUtils;
import com.example.SpringSecurity_JWTAuthentication.model.JwtResponse;
import com.example.SpringSecurity_JWTAuthentication.model.UserModel;
import com.example.SpringSecurity_JWTAuthentication.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/token")
    public ResponseEntity<?> genrateToken(@RequestBody UserModel userModel) throws Exception {
        try {
            this.authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(userModel.getUserName(),userModel.getPassword()));
        }
        catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw  new Exception("Invalid crenditials");
        }

        //after authenticated
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(userModel.getUserName());

        //now generate token
        String token= this.jwtUtils.generateToken(userDetails);
            //{token:value}
        return ResponseEntity.ok().body(new JwtResponse(token));
    }
}
