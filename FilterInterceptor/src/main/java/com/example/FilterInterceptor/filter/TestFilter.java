package com.example.FilterInterceptor.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.addHeader("custom-header","filter-value");
        System.out.println("before do filtre");
        filterChain.doFilter(servletRequest,response);
        System.out.println("after do filtre");

    }
}
