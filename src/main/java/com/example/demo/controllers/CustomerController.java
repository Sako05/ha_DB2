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




    @GetMapping(path = "/add/{firstname}/{lastname}/{email}/{password}/{address}/{zipcode}/{city}/{userIs}")
    public String addCustomer(@PathVariable  String firstname, @PathVariable String lastname, @PathVariable String email, @PathVariable String password, @PathVariable String address, @PathVariable Long zipcode, @PathVariable String city, @PathVariable String userIs){
        Customer b = new Customer();
        b.setFirstname(firstname);
        b.setLastname(lastname);
        b.setEmail(email);
        b.setPassword(password);
        b.setAddress(address);
        b.setZipcode(zipcode);
        b.setCity(city);
        b.setUserIs(userIs);
        customerRepository.save(b);
        return "Customer saved";
    }

    @PatchMapping(path = "/update/{id}/{firstname}/{lastname}/{email}/{address}/{zipcode}/{city}")
    public String updateCustomer(@PathVariable String id, @PathVariable  String firstname, @PathVariable String lastname, @PathVariable String email, @PathVariable String address, @PathVariable Long zipcode, @PathVariable String city) {
        Customer customer = customerRepository.findById(Long.valueOf(id)).orElseThrow();

        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setZipcode(zipcode);
        customer.setCity(city);

        customerRepository.save(customer);

        return "Customer updated";

    }


    @DeleteMapping (path = "/{id}")
    public String deleteCustomer(@PathVariable int id) {
        for (Customer p : customerRepository.findAll()) {
            if (p.getId() == id) {
                customerRepository.delete(p);

            }
        }


        return "Customer deleted";
    }





    @PatchMapping(path = "/update/{id}/{password}")
    public String updateCustomerPassword(@PathVariable String id, @PathVariable String password) {
        Customer customer = customerRepository.findById(Long.valueOf(id)).orElseThrow();

        customer.setPassword(password);

        customerRepository.save(customer);

        return "Customer password updated";

    }


    @GetMapping("/get/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id){
        return customerRepository.findById(id);
    }



    @GetMapping(path="/all")
    public @ResponseBody Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }


}