package com.example.demo.controllers;

import com.example.demo.model.*;
import com.example.demo.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.demo.model.Payment;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.OrdersRepository;
import com.example.demo.repositories.PaymentRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping(path ="/add")
    public String addOrUpdatePayment(@RequestParam String reference, @RequestParam String status){

            Payment payment = paymentRepository.findByReference(reference)
                    .orElse(new Payment(reference, status));

            payment.setStatus(status);
            paymentRepository.save(payment);

        return "Payment was added";
    }

    @GetMapping(path ="/get/status/{reference}")
    public Optional<Payment> getPaymentStatus(@PathVariable String reference){
        return paymentRepository.findByReference(reference);
    }




    @GetMapping(path="/all")
    public @ResponseBody Iterable<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }



}
