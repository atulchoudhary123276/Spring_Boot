package com.example.SpringSecurityExample.repository;

import com.example.SpringSecurityExample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Repo extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String userName);
}
