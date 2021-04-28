package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Category implements Serializable {

    @Id

    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY) //categories = TABLENAMÉ
    @JsonBackReference
    private Set<Product> products = new HashSet<>();


    public Category(){}

    public Category(String name) {
        this.name = name;
    }


    public Category(Long id, String name) {
        this.id = id;
        this.name = name;


    }

    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
