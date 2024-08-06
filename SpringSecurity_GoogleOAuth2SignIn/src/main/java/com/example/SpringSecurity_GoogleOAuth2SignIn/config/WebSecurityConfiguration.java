package com.example.SpringSecurity_GoogleOAuth2SignIn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
//                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/index.html","/welcome")
                .permitAll()
                .anyRequest()
                .authenticated();

        //both are same ...
//        http
//                .csrf()
//                .disable()
//                .cors()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/", "/index.html","/welcome")
//                .permitAll()
//                .anyRequest()
//                .authenticated();

    }


}
