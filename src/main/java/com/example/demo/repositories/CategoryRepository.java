package com.example.demo.repositories;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findCategoryByName(String name);
}
