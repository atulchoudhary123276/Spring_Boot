package com.example.SpringSecurityExample.securityConfig;

import com.example.SpringSecurityExample.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration  {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception
//    {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder())
//                .withUser("gfg")
//                .password(passwordEncoder().encode("pass"))
//                .roles("ADMIN")
//                .and()
//                .passwordEncoder(passwordEncoder())
//                .withUser("user")
//                .password(passwordEncoder().encode("pass"))
//                .roles("BASIC");
//    }
//
//    // Annotation
    @Bean
    // Method
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }
//
//    // Annotation
//    @Override
//    // Method
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
    @Bean
    public UserDetailsService userDetailsService(){
        return new LoginService();
    }
}
