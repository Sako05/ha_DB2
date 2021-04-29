package com.example.demo.controllers;


import com.example.demo.model.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/customer")
@CrossOrigin
public class CustomerController {


    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping(path = "/add")
    public String addCustomer(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String password, @RequestParam String address, @RequestParam Long zipcode, @RequestParam String city){
        Customer b = new Customer();
        b.setFirstname(firstname);
        b.setLastname(lastname);
        b.setEmail(email);
        b.setPassword(password);
        b.setAddress(address);
        b.setZipcode(zipcode);
        b.setCity(city);
        customerRepository.save(b);
        return "Customer saved";
    }


    @GetMapping("/get/{id}")
    public Optional<Customer> getByOrderId(@PathVariable Long id){
        return customerRepository.findById(id);
    }



    @GetMapping(path="/all")
    public @ResponseBody Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }


}
