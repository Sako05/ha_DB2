package com.example.demo;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    MockMvc MockMvc;

    private final static WireMockServer wireMockServer = new WireMockServer(1234);

    @BeforeEach
    public void before() {
        wireMockServer.start();
    }

    @AfterEach
    public void after() {
        wireMockServer.stop();
    }



}
