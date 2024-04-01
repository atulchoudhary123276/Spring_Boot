package com.example.FilterInterceptor.config;

import com.example.FilterInterceptor.filter.TestFilter;
import com.example.FilterInterceptor.interceptor.TestInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TestConfig implements WebMvcConfigurer {
//    TestInterceptor testInterceptor;
//    TestConfig(TestInterceptor testInterceptor) {
//        this.testInterceptor = testInterceptor;
//    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/*");

    }

     /*  We can also execute filter classes based on specific URL.
         For this we need to create one new configuration class
         and need to register bean and will set which filter class we want to restrict.*/

//    @Bean
//    public FilterRegistrationBean<TestFilter> registrationBean(){
//        FilterRegistrationBean<TestFilter> registrationBean=new FilterRegistrationBean<>();
//        registrationBean.setFilter(new TestFilter());
//        registrationBean.addUrlPatterns("/hi");
//
//        return registrationBean;
//    }
}
