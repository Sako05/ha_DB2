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

    @PostMapping(path = "/add")
    public String addNewCategory(@RequestParam String categoryname) {
        Category n = new Category();
        n.setName(categoryname);
        categoryRepository.save(n);
        return categoryname + " is Saved";
    }

    @GetMapping(path = "/all")
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PatchMapping(path = "/{id}")
    public String updateName(@PathVariable int id, @RequestParam String value) {
        for (Category c : categoryRepository.findAll()) {
            if (c.getId() == id) {
                c.setName(value);
                categoryRepository.save(c);
                return "Category name changed.";
            }
        }

        return "Could not find category by id: " + id + ".";
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCategory(@PathVariable int id) {
        for (Category c : categoryRepository.findAll()) {
            if (c.getId() == id) {
                categoryRepository.delete(c);
                return "Category " + c.getName() + " deleted.";
            }
        }

        return "Could not find category by id: " + id + ".";
    }

}
