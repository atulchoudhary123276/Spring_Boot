package com.example.SpringSecurity_JWTAuthentication.repository;

import com.example.SpringSecurity_JWTAuthentication.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {
    Optional<UserModel> findByUserName(String uerName);
}
