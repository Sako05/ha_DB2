package com.example.demo.controllers;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/category")
@CrossOrigin

public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping(path = "/add")
    public String addNewCategory(@RequestParam String name) {
        Category c = new Category();
        c.setName(name);
        categoryRepository.save(c);
        return name + " is Saved";
    }

    @GetMapping(path = "/all")
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PatchMapping(path = "/{id}/catname")
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
        if (remove(id)) {
            return "Success deleteting category";
        }
        return "Could not delete category";
    }


    public boolean remove(int id) {
        for (Category c : categoryRepository.findAll()) {
            if (c.getId() == id) {
                for (Product p : c.getProducts()) {
                    p.getCategories().remove(c);
                    categoryRepository.delete(c);
                    return true;
                }
            }
        }
        return false;
    }
}
