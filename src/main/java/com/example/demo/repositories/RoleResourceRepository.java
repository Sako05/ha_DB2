package com.example.demo.repositories;

import com.example.demo.domain.RoleApp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleResourceRepository extends JpaRepository<RoleApp, Long> {
    RoleApp findByName(String name);

}
