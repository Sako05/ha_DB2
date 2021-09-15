package com.example.demo.repositories;

import com.example.demo.model.Order_Row;
import com.example.demo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface PaymentRepository extends CrudRepository<Payment, String> {

    Payment findByReference(String reference);
}
