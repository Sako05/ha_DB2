package com.example.demo;


import com.example.demo.controllers.OrdersController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@AutoConfigureMockMvc
@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads()
    {}

    @AfterEach
    public void after() {
        wireMockServer.stop();
    }



}
