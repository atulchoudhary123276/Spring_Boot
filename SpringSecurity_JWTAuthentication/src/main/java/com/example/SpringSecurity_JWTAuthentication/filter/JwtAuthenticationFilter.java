package com.example.SpringSecurity_JWTAuthentication.filter;

import com.example.SpringSecurity_JWTAuthentication.helper.JwtUtils;
import com.example.SpringSecurity_JWTAuthentication.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtUtils utils;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //get jwt
        //bearer
        //validate
        String token = httpServletRequest.getParameter("token");
        String requestURI = httpServletRequest.getRequestURI();
        String requestTokenHeader = httpServletRequest.getHeader("Authorization");
        String userName = null;
        String jwtToken = null;
        if ((requestTokenHeader != null && requestTokenHeader.startsWith("Bearer "))|| (token!=null && token.startsWith("Bearer "))) {
            jwtToken=(token.isBlank())?requestTokenHeader.substring(7):token.substring(7);
//            jwtToken = ;
            System.out.println("tokn "+jwtToken);
            try {
                userName = this.utils.extractUsername(jwtToken);
            } catch (Exception e) {
                System.out.println("Token not valid ");
            }
        }
        else if (!requestURI.contains("/token")) {
            System.out.println("Authorization Header not Found in RequestHeader");
        }

        //securitycontexholder set token
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);

            if (utils.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);


    }
}
