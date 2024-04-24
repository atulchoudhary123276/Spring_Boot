package com.example.SpringSecurity_JWTAuthentication.SecurityException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
    private int status;
    private String message;
    private Object result;
    public ApiResponse(int status, String message, Object result){
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public ApiResponse(int status, String message){
        this.status = status;
        this.message = message;
    }
}
