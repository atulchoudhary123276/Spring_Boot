package com.example.SpringSecurity_JWTAuthentication.service;

import com.example.SpringSecurity_JWTAuthentication.model.UserModel;
import com.example.SpringSecurity_JWTAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> byUserName = userRepository.findByUserName(username);
        if (byUserName.isPresent()){
            UserModel userModel = byUserName.get();
            GrantedAuthority authority=new SimpleGrantedAuthority("ROLE_USER");  //set the role for user
            GrantedAuthority authority1=new SimpleGrantedAuthority("ROLE_ADMIN");  //set the role for user
            return new User(userModel.getUserName(),userModel.getPassword(), List.of(authority,authority1));
        }
        else {
            throw  new UsernameNotFoundException("user not found");
        }
    }
    public void saveUser(UserModel user) {
        userRepository.save(user);
    }
}
