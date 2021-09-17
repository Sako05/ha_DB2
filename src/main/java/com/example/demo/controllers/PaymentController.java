package com.example.demo.controllers;

import com.example.demo.model.Payment;
import com.example.demo.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping(path ="/add/{reference}/{status}")
    public String addOrUpdatePayment(@PathVariable String reference, @PathVariable String status){

            Payment payment = paymentRepository.findByReference(reference)
                    .orElse(new Payment(reference, status));

            payment.setStatus(status);
            paymentRepository.save(payment);

        return "Payment was added";
    }
}
