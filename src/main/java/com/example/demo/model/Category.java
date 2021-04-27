package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long cat_id;
    private String categoryname;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "categories") //categories = TABLENAMÉ
    private Set<Product> products = new HashSet<>();


    public Category(){}

    public Category(String categoryname) {
        this.categoryname = categoryname;
    }

    public Long getCat_id() {
        return cat_id;
    }

    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }

    public String getCategoryname() {
        return categoryname;
    }



    public void setCategoryName(String categoryname) {
        this.categoryname = categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
