package com.example.demo.controllers;


import com.example.demo.model.Payment;
import com.example.demo.repositories.PaymentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")


public class PaymentControllerTest {

    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentRepository mockRepository;


    @Before
    public void init() {
        Payment payment = new Payment(1L, "123DE", "PAID");
        when(mockRepository.findByReference("123DE")).thenReturn(Optional.of(payment));

    }

    @Test
    public void save() throws Exception{

        mockMvc.perform(post("/payment/add?reference=566SE&status=PAID"))
                .andExpect(content().string("Payment was added"));
    }

    @Test
    public void expectSuccessful() throws Exception{

        mockMvc.perform(post("/payment/add?reference=566SE&status=PAID"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void expectClientError() throws Exception{

        mockMvc.perform(post("/payment/add?refereence=566SE&status=PAID"))
                .andExpect(status().is4xxClientError());
    }




}
