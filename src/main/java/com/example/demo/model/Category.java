package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;


    public Category(){}

    public Category(String categoryname) {
        this.name = categoryname;
    }

    public Category(Long id, String categoryname) {
        this.id = id;
        this.name = categoryname;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
