package com.example.demo.repositories;

import com.example.demo.model.Category;
import com.example.demo.model.Customer;

import com.example.demo.model.Orders;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findById(Long id);
}
