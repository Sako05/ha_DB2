package com.example.demo.controllers;


import com.example.demo.model.Category;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/category")
@CrossOrigin


public class CategoryController {


    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(path = "/add")
    public String addNewCategory(@RequestParam String categoryname) {
        Category n = new Category();
        n.setCategoryname(categoryname);
        categoryRepository.save(n);
        return categoryname + "is Saved";
    }

    @GetMapping(path = "/all")
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
