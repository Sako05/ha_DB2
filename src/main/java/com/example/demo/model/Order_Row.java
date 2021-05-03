package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Order_Row implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long id;
    private Long quantity;

    @JoinColumn
    @ManyToOne
    private Orders orders;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;


    public Order_Row(){}

    public Order_Row(Long id, Orders orders, Product product, Long quantity) {
        this.id = id;
        this.orders = orders;
        this.product = product;
        this.quantity = quantity;
    }

    public Order_Row(Orders orders, Product product, Long quantity) {
        this.orders = orders;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
