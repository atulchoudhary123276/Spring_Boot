//package com.example.SpringBoot_i18n.filter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.support.RequestContextUtils;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Locale;

// 2nd way to implement the i18n using filter
////@Component
//public class LocaleFilter extends OncePerRequestFilter  {
//    @Autowired
//    private LocaleResolver localeResolver;
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        System.out.println("Execute filter on this request");
//
//        filterChain.doFilter(request, response);
//
//        String language = request.getParameter("language");
//        if (language != null) {
//            System.out.println(localeResolver);
//            localeResolver.setLocale(request, response, StringUtils.parseLocale(language));
//        }
//        else {
//            localeResolver.setLocale(request,response,Locale.US);
//        }
//        System.out.println("Execute filter on the response");
//    }
//}
