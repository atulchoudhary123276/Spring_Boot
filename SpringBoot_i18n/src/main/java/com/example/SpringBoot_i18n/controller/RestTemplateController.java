package com.example.SpringBoot_i18n.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;


//this is only for rest template example
@RestController
public class RestTemplateController {
    //here we need to provide new object or @Bean in config file , bcz here autowire is not work
    private RestTemplate restTemplate=new RestTemplate();

    @GetMapping("/rest")
    public String getRestTemplateResult(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        String restResponse = restTemplate.exchange("http://localhost:8087/open", HttpMethod.GET, entity, String.class).getBody();
        System.out.println(restResponse);
        return restResponse+" hello i am rest template";
    }
}
