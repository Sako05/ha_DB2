package com.example.demo.controllers;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;


@RestController
@RequestMapping(path = "/product")
@CrossOrigin
public class ProductController {



    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping(path="/addWCategory")
    public String addProductWithCategory(@RequestParam String name, @RequestParam Long price, @RequestParam String description, @RequestParam String imageURL, @RequestParam Long quantity, @RequestParam Long categoryId){
        Product n = new Product();
        n.setName(name);
        n.setPrice(price);
        n.setDescription(description);
        n.setImageURL(imageURL);
        n.setQuantity(quantity);

        for (Category c : categoryRepository.findAll()) {
            if (c.getId().equals(categoryId)) {
                n.setCategory(Collections.singletonList(c));
            } else {
                return "Category not found";
            }
        }

        productRepo.save(n);
        return "Saved";
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Product> getAllProducts(){
        return productRepo.findAll();
    }

    @GetMapping(path = "/{id}")
    public Product getProductByID(@PathVariable int id) {
        for (Product p : productRepo.findAll()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @DeleteMapping (path = "/{id}")
    public void deleteProduct(@PathVariable int id) {
        for (Product p : productRepo.findAll()) {
            if (p.getId() == id) {
                productRepo.delete(p);
            }
        }
    }

    @PatchMapping(path = "/{id}/name")
    public String updateName(@PathVariable String id, @RequestParam String value) {
        Product prod = productRepo.findById(Long.valueOf(id)).orElseThrow();

        if (prod != null) {
            prod.setName(value);
            productRepo.save(prod);
            return "Product name updated";
        }

        return "No product by id found";
    }

    @PatchMapping(path = "/{id}/price")
    public String updatePrice(@PathVariable String id, @RequestParam int value) {
        Product prod = productRepo.findById(Long.valueOf(id)).orElseThrow();

        if (prod != null) {
            prod.setPrice((long) value);
            productRepo.save(prod);
            return "Product price updated";
        }

        return "No product by id found";
    }

    @PatchMapping(path = "/{id}/description")
    public String updateDescription(@PathVariable String id, @RequestParam String value) {
        Product prod = productRepo.findById(Long.valueOf(id)).orElseThrow();

        if (prod != null) {
            prod.setDescription(value);
            productRepo.save(prod);
            return "Product description updated";
        }

        return "No product by id found";
    }

    @PatchMapping(path = "/{id}/imageURL")
    public String updateImageURL(@PathVariable String id, @RequestParam String value) {
        Product prod = productRepo.findById(Long.valueOf(id)).orElseThrow();

        if (prod != null) {
            prod.setImageURL(value);
            productRepo.save(prod);
            return "Product image updated";
        }

        return "No product by id found";
    }

    @PatchMapping(path = "/{id}/quantity")
    public String updateQuantity(@PathVariable String id, @RequestParam int value) {
        Product prod = productRepo.findById(Long.valueOf(id)).orElseThrow();

        if (prod != null) {
            prod.setQuantity((long) value);
            productRepo.save(prod);
            return "Product quantity updated";
        }

        return "No product by id found";
    }
}
