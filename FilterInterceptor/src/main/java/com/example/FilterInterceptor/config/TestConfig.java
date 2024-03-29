package com.example.FilterInterceptor.config;

import com.example.FilterInterceptor.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TestConfig implements WebMvcConfigurer {
    TestInterceptor testInterceptor;
    TestConfig(TestInterceptor testInterceptor) {
        this.testInterceptor = testInterceptor;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor);
    }
}
