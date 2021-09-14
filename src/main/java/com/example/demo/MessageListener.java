package com.example.demo;

import com.example.demo.model.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class MessageListener {

    @RabbitListener(queues = MQConfiguration.PAYMENT_QUEUE)
    public void listener(String payment) throws JsonProcessingException {
        System.out.println(payment);


        //TODO: Flytta nedan till annan klass
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(payment);
        String reference = jsonNode.get("reference").asText();
        String status = jsonNode.get("status").asText();

        Payment newPayment = new Payment(reference, status);
        System.out.println(newPayment.getReference()+"  "+newPayment.getStatus());
    }
}
