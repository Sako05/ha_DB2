package com.example.demo.controllers;


import com.example.demo.model.Order_Row;
import com.example.demo.model.Orders;
import com.example.demo.model.Product;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/order/row")
@CrossOrigin
public class Order_RowController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private Order_RowRepository order_rowRepository;


    @GetMapping(path ="/add/{orderID}/{productID}/{quantity}")
    public String AddOrderRow(@PathVariable Long orderID, @PathVariable Long productID, @PathVariable Long quantity){

        Orders ordersID = ordersRepository.findById(orderID)
                .orElse(new Orders());

        Product productsID = productRepository.findById(productID)
                .orElse(new Product());

        Order_Row c = new Order_Row(ordersID, productsID, quantity);
        order_rowRepository.save(c);

        return "Product was added to order";

    }

    @GetMapping(path="/get/OrderID/{ordersID}")
    public Iterable<Order_Row> getOrderWithProduct(@PathVariable Long ordersID) {
        return order_rowRepository.findOrdersWithProducts(ordersID);
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Order_Row> getAllOrderRow() {
        return order_rowRepository.findAll();
    }

    @DeleteMapping (path = "/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id) {

        Order_Row row = order_rowRepository.findById(id)
                .orElse(new Order_Row());

        order_rowRepository.delete(row);

        return "Product was deleted from order";

    }








}
