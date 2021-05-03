package com.example.demo.repositories;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findCategoryByName(String name);

    @Query(value = "SELECT category.id, category.name, product.description FROM product_category\n" +
            "INNER JOIN category ON product_category.cat_id = category.id\n" +
            "INNER JOIN product ON product_category.prod_id = product.id \n" +
            "WHERE product_category.prod_id=:productID", nativeQuery =
            true)
    Iterable<Category> findCategoryByProductID(@Param("productID") Long productID);

}
