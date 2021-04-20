package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String categoryname;


    public Category(){}

    public Category(String categoryname) {
        this.categoryname = categoryname;
    }

    public Category(Long id, String categoryname) {
        this.id = id;
        this.categoryname = categoryname;

    }

    public Long getId() {
        return id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategoryName(String categoryname) {
        this.categoryname = categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}
