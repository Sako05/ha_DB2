package com.example.demo.controllers;

import com.example.demo.model.*;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "/product")
@CrossOrigin
public class ProductController {



    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private CategoryRepository categoryRepository;
    private Optional<Category> finalCat;

    @PostMapping(path="/addWCategory")
    public String addProductWithCategory(@RequestParam String name, @RequestParam Long price, @RequestParam String description, @RequestParam String imageURL, @RequestParam Long quantity, @RequestParam(defaultValue = "0") String categoryId){
        Product n = new Product();
        n.setName(name);
        n.setPrice(price);
        n.setDescription(description);
        n.setImageURL(imageURL);
        n.setQuantity(quantity);

        if (!categoryId.equals("0")) {
            Long catID = Long.valueOf(categoryId);
            finalCat = categoryRepository.findById(catID);

            if (finalCat.isPresent()) {
                for (Category c : finalCat.stream().collect(Collectors.toList())) {
                    if (c.getId().equals(catID)) {
                        n.setCategories(Collections.singleton(c));
                    } else {
                        return "Category not found";
                    }
                }
            }
        } else {
            n.setCategories(null);
        }

        productRepo.save(n);
        return "Saved";
    }

    @PatchMapping(path = "/update/{id}/{name}/{price}/{description}/{imageURL}/{quantity}")
    public String updateProductWithCategory(@PathVariable String id, @PathVariable String name, @PathVariable Long price, @PathVariable String description, @PathVariable String imageURL, @PathVariable Long quantity){
        Product product = productRepo.findById(Long.valueOf(id)).orElseThrow();


            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setImageURL(imageURL);
            product.setQuantity(quantity);

            productRepo.save(product);
            return "Product name updated";

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

    @GetMapping(path="/get/productWcategory/{categoryID}")
    public Iterable<Product> getOrderID(@PathVariable Long categoryID) {
        return productRepo.findProductByCategory(categoryID);
    }

    @GetMapping(path="/get/orderbyid/{ordersID}")
    public Iterable<Product> getOrderByID(@PathVariable Long ordersID) {
        return productRepo.findOrderByID(ordersID);
    }

    @GetMapping(path="/get/allcustomerorders/{ordersID}")
    public Iterable<Product> CustomerOrders(@PathVariable Long ordersID) {
        return productRepo.findAllCustomerOrders(ordersID);
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