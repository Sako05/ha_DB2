package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private Long price;
    private String description;
    private String imageURL;
    private Long quantity;


    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="product_category", joinColumns={@JoinColumn(name="productID")},
            inverseJoinColumns={@JoinColumn(name="categoryID")})
            private List<Category> category;

    public Product(){}

    public Product(String title, Long price, String description, String imageURL, Long quantity){
        this.title = title;
        this.price = price;
        this.description = description;
        this.imageURL = imageURL;
        this.quantity = quantity;

    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getTitle() {
        return title;
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


    public Long getId() {
        return id;
    }


    public Long getPrice() {
        return price;
    }



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
