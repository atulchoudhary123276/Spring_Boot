package com.example.SpringSecurity_JWTAuthentication.controller;

import com.example.SpringSecurity_JWTAuthentication.helper.JwtUtils;
import com.example.SpringSecurity_JWTAuthentication.model.JwtResponse;
import com.example.SpringSecurity_JWTAuthentication.model.UserModel;
import com.example.SpringSecurity_JWTAuthentication.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
public class JwtController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/token")
    public String genrateToken(@ModelAttribute UserModel userModel, HttpServletResponse response) throws Exception {
        try {
            this.authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(userModel.getUserName(), userModel.getPassword()));
            //after authenticated
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(userModel.getUserName());

            //add  extra things into token
            HashMap<String, Object> info = new HashMap<>();
            info.put("name", "Atul Chaudhary");
            info.put("address", "Noida");
            this.jwtUtils.addIntoToken(info);
            //now generate token
            String token = this.jwtUtils.generateToken(userDetails);
            //{token:value}

//        return ResponseEntity.ok().body(new JwtResponse(token));
//            ModelAndView modelAndView = new ModelAndView("home"); // Replace "home" with the name of your view page
//            modelAndView.addObject("token", token);
            // Set JWT token in the response header
            response.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);

            return "redirect:/home?token=Bearer " + token;
//            return ResponseEntity.ok()
//                    .header(
//                            HttpHeaders.AUTHORIZATION,
//                            this.jwtUtils.generateToken(userDetails)
//                    )
//                    .body(userDetails);
        } catch (BadCredentialsException ex) {
            ModelAndView errorModelAndView = new ModelAndView("errorPage"); // Return error page if authentication fails
            errorModelAndView.setStatus(HttpStatus.UNAUTHORIZED);
            return "error occured";
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
