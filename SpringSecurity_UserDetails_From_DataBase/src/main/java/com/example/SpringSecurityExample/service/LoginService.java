package com.example.SpringSecurityExample.service;
import com.example.SpringSecurityExample.model.User;
import com.example.SpringSecurityExample.repository.Repo;
import com.example.SpringSecurityExample.model.UserLoginToModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class LoginService implements UserDetailsService {
    @Autowired
    private Repo repo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> byUserName = repo.findByUserName(s);
        if (byUserName.isPresent()){
            User user = byUserName.get();
//            System.out.println("User: "+user);
            return new UserLoginToModel(user);
        }
        else throw new UsernameNotFoundException("user not found ");
    }
}
