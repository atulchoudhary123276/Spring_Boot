package com.example.SpringBoot_i18n.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

//@Configuration
//public class MessageConfig implements WebMvcConfigurer {
//    @Bean
//    public LocaleResolver localeResolver() {
//        SessionLocaleResolver slr = new SessionLocaleResolver();           //SessionLocaleResolver
//        // Resolves the locale and stores it in the HttpSession of the user
//        slr.setDefaultLocale(Locale.US);
////        slr.setLocaleAttributeName("session.current.locale");
////        slr.setTimeZoneAttributeName("session.current.timezone");
//        return slr;
//    }


    //LocaleChangeInterceptor is a used to change the new Locale
    // based on the value of the language  parameter added to request .
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("language");
//        return localeChangeInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeChangeInterceptor());
//    }

    //    @Bean("messageSource")
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource =
//                new ResourceBundleMessageSource();
//        messageSource.setBasenames("language/messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }

// 2nd way to implement the i18n using filter
//    @Autowired
//    private LocaleFilter localeFilter;
//
//    @Bean
//    public FilterRegistrationBean<LocaleFilter> localeFilterRegistrationBean() {
//        FilterRegistrationBean<LocaleFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(localeFilter);
//        registrationBean.addUrlPatterns("/message", "/country", "/currency");
//        return registrationBean;
//    }
//}