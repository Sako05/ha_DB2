package com.example.demo.controllers;

import com.example.demo.model.Customer;
import com.example.demo.model.Orders;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.OrdersRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/orders")
@CrossOrigin
public class OrdersController {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrdersRepository ordersRepository;


    @GetMapping(path ="/add/{address}/{customerid}")
    public String addOrder(@PathVariable String address, @PathVariable Long customerid){


        Customer customer = customerRepository.findById(customerid)
                .orElse(new Customer());


        Orders c = new Orders(address, customer);
        ordersRepository.save(c);

        return "Order was added";
    }

    @DeleteMapping (path = "/deleteorder/{id}")
    public String deleteOrder(@PathVariable Long id) {

        Orders orders = ordersRepository.findById(id)
                .orElse(new Orders());

        ordersRepository.delete(orders);

        return "Order was deleted";

    }

    @GetMapping(path="/get/OrderID/{customerID}")
    public Iterable<Orders> getOrderID(@PathVariable Long customerID) {
        return ordersRepository.findByCustomerIDorderID(customerID);
    }



    @GetMapping(path="/all")
    public @ResponseBody Iterable<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }


   @GetMapping(path="/all/{id}")
    public Optional<Orders> getOrderByid(@PathVariable Long id){


        return ordersRepository.findById(id);
    }







}
