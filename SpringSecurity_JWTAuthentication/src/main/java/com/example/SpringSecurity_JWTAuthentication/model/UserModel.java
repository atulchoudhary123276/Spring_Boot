package com.example.SpringSecurity_JWTAuthentication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName,password;
}
