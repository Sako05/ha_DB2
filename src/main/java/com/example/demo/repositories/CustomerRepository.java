package com.example.demo.repositories;

import com.example.demo.model.Category;
import com.example.demo.model.Customer;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findById(Long id);
}
