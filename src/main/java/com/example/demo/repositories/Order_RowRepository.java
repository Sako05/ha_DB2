package com.example.demo.repositories;

import com.example.demo.model.Order_Row;
import com.example.demo.model.Orders;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Order_RowRepository  extends CrudRepository<Order_Row, Long> {
    @Query(value = "SELECT * FROM order_row\n" +
            "INNER JOIN orders ON order_row.orders_id = orders.id\n" +
            "INNER JOIN product ON order_row.product_id = product.id \n" +
            "WHERE order_row.orders_id=:ordersID", nativeQuery =
            true)
    Iterable<Order_Row> findOrdersWithProducts(@Param("ordersID") Long ordersID);

}
