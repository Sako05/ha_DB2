package com.example.demo.controllers;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


@RestController
@RequestMapping(path = "/products")
@CrossOrigin
public class ProductController {



    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping(path="/add")
    public String addProductByPost(@RequestParam String name, @RequestParam Long price, @RequestParam String description, @RequestParam String imageURL, @RequestParam Long quantity){
        Product b = new Product();
        b.setName(name);
        b.setPrice(price);
        b.setDescription(description);
        b.setImageURL(imageURL);
        b.setQuantity(quantity);
        productRepo.save(b);
        return "Saved";
    }

    @GetMapping(path="/addWCategory")
    public String addProductWithCategory(@RequestParam String name, @RequestParam Long price, @RequestParam String description, @RequestParam String imageURL, @RequestParam Long quantity, @RequestParam Long categoryId){
        Product n = new Product();
        n.setName(name);
        n.setPrice(price);
        n.setDescription(description);
        n.setImageURL(imageURL);
        n.setQuantity(quantity);


        Category p = categoryRepository.findById(categoryId).get();
        if(p != null){
            n.setCategory(Collections.singletonList(p));
        }


        productRepo.save(n);
        return "Saved";
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Product> getAllProducts(){
        return productRepo.findAll();
    }
}
