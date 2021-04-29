package com.example.demo.repositories;

import com.example.demo.model.Order_Row;
import com.example.demo.model.Orders;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Order_RowRepository  extends CrudRepository<Order_Row, Long> {

}
