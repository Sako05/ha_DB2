package com.example.demo.repositories;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.*;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findById(Long id);





}