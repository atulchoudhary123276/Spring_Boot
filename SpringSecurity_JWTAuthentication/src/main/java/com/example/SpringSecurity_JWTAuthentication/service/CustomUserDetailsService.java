package com.example.SpringSecurity_JWTAuthentication.service;

import com.example.SpringSecurity_JWTAuthentication.model.UserModel;
import com.example.SpringSecurity_JWTAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            return new User(userModel.getUserName(),userModel.getPassword(),new ArrayList<>());
        }
        else {
            throw  new UsernameNotFoundException("user not found");
        }
    }
    public void saveUser(UserModel user) {
        userRepository.save(user);
    }
}
