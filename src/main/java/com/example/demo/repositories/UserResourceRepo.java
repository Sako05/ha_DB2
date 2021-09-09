package com.example.demo.repositories;

import com.example.demo.domain.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResourceRepo extends JpaRepository<UserApp, Long> {
    UserApp findByUsername(String username);
}
