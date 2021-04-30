package com.example.demo.repositories;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findById(Long id);


    @Query(value = "SELECT product.id, product.name, product.price, product.description, product.imageurl, product.quantity FROM product_category\n" +
            "INNER JOIN product ON product_category.prod_ID = product.ID\n" +
            "INNER JOIN category ON product_category.cat_ID = category.ID\n" +
            "WHERE product_category.cat_id =:categoryID", nativeQuery =
            true)
    Iterable<Product> findProductByCategory(@Param("categoryID") Long categoryID);




}