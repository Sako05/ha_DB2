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


    @Query(value = "SELECT product.id, product.name, product.price, product.description, product.imageurl, order_row.quantity FROM order_row\n" +
            "INNER JOIN product ON order_row.product_ID = product.ID\n" +
            "INNER JOIN orders ON order_row.orders_ID = orders.ID\n" +
            "WHERE order_row.orders_id =:ordersID", nativeQuery =
            true)
    Iterable<Product> findOrderByID(@Param("ordersID") Long ordersID);

    @Query(value = "SELECT product.id, orders.id, product.name, product.price, product.description, product.imageurl, order_row.quantity FROM order_row\n" +
            "INNER JOIN product ON order_row.product_ID = product.ID\n" +
            "INNER JOIN orders ON order_row.orders_id = orders.ID\n" +
            "INNER JOIN customer ON orders.customer_id = customer.id\n" +
            "WHERE orders.id =:ordersID", nativeQuery =
            true)
    Iterable<Product> findAllCustomerOrders(@Param("ordersID") Long customersID);









}