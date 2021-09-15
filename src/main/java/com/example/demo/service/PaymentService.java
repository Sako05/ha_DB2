package com.example.demo.service;


import com.example.demo.model.Payment;
import com.example.demo.repositories.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;


public class PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    public void processPayment(String payment) throws JsonProcessingException {
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(payment);
        String reference = jsonNode.get("reference").asText();
        //String status = jsonNode.get("status").asText();

        //if(status.equalsIgnoreCase("CREATED")) {
            Payment newPayment = new Payment(reference, "PAID");
            paymentRepository.save(newPayment);
       // }
       // if(status.equalsIgnoreCase("PAID")) {
            //TODO: Ändra status från befintlig payment till PAID i databasen
       // }
    }
}
