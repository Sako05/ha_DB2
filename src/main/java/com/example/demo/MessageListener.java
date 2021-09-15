package com.example.demo;


import com.example.demo.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class MessageListener {

    @RabbitListener(queues = MQConfiguration.PAYMENT_QUEUE)
    public void listener(String payment) throws JsonProcessingException {
        PaymentService ps = new PaymentService();
        ps.processPayment(payment);

    }
}
