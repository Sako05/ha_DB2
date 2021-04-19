package com.example.demo.controllers;

import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/products")
public class ProductController {



    @Autowired
    private ProductRepository productRepo;

    @GetMapping(path="/add")
    public @ResponseBody String addProduct(@RequestParam String product_name, @RequestParam Long price, @RequestParam String description, @RequestParam String imageURL, @RequestParam Long quantity){
        Product b = new Product(product_name, price,description,imageURL,quantity);
        b.setProductName(product_name);
        b.setPrice(price);
        b.setDescription(description);
        b.setImageURL(imageURL);
        b.setQuantity(quantity);
        productRepo.save(b);
        return "Product was saved";
    }

    @PostMapping(path="/add")
    public @ResponseBody String addProductByPost(@RequestParam String product_name, @RequestParam Long price, @RequestParam String description, @RequestParam String imageURL, @RequestParam Long quantity){
        Product b = new Product(product_name, price,description,imageURL,quantity);
        productRepo.save(b);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    List<Product> getAllProducts(){
        return (List<Product>)productRepo.findAll();
    }
}
