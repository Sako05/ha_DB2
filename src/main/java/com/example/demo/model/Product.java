package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String product_name;
    private Long price;
    private String description;
    private String imageURL;
    private Long quantity;

    public Product(){}

    public Product(String product_name, Long price, String description, String imageURL, Long quantity){
        this.product_name = product_name;
        this.price = price;
        this.description = description;
        this.imageURL = imageURL;
        this.quantity = quantity;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.product_name = productName;
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

    public String getProductName() {
        return product_name;
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
                ", productName='" + product_name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
