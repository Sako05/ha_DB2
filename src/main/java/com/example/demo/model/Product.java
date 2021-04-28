package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private Long price;
    private String description;
    private String imageURL;
    private Long quantity;


    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinTable(name="product_category",
            joinColumns={ @JoinColumn(name="prod_id")},
            inverseJoinColumns={ @JoinColumn(name="cat_id")})

    private Set<Category> categories = new HashSet<>();

    public Product(){}

    public Product(String name, Long price, String description, String imageURL, Long quantity){
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageURL = imageURL;
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String title) {
        this.name = title;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public String getImageURL() {
        return imageURL;
    }

    public Long getQuantity() {
        return quantity;
    }


    public Long getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
