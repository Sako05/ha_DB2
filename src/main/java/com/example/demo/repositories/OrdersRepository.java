package com.example.demo.repositories;

import com.example.demo.model.Customer;
import com.example.demo.model.Orders;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends CrudRepository<Orders, Long> {

    @Query(value = "SELECT * FROM orders WHERE  customer_id =:customerID ORDER BY dataoforder DESC LIMIT  1", nativeQuery =
            true)
    Iterable<Orders> findByCustomerIDorderID(@Param("customerID") Long customerID);



}
