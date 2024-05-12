package com.example.SpringBoot_i18n.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Data
public class ApiResponse {
    @Value("${title}")
    private String message;
            private String locale;

}
