package com.example.SpringSecurity_InMemoryUserValidation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //--1st way using bean
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user = User.builder()
//                .username("atul")
//                .password(passwordEncoder().encode("aa"))
//                .roles("USER")
//                .build();
//        System.out.println("password:-------"+user.getPassword());
//        return new InMemoryUserDetailsManager(user);
//
//    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

   //---------second way with implementing webSecurityconfiguration..
    @Override            //For Authentication
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception
    {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("atul")
                .password(passwordEncoder().encode("aa"))
                .roles("ADMIN");

    }

    // Annotation
//    @Override
//    // Method       for Authorization
//    protected void configure(HttpSecurity http) throws Exception
//    {
//
//        http.authorizeRequests()
//                .antMatchers("/basic")
//                .hasAnyRole("BASIC", "ADMIN")
//                .antMatchers("/admin")
//                .hasRole("ADMIN")
//                .antMatchers("/")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .permitAll()
//                .loginPage("/login")
//                .usernameParameter("username")
//                .and()
//                .logout()
//                .logoutRequestMatcher(
//                        new AntPathRequestMatcher("/logout"))
//                .permitAll();
//    }
}
