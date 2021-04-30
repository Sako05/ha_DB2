package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.model.*;
import com.example.demo.repositories.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


import java.util.List;


@SpringBootApplication
public class DemoApplication {

    @Autowired
    ProductRepository productRepositoryRepo;

    @Autowired
    CategoryRepository categoryRepository;

    private Optional<Category> finalCat;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


}