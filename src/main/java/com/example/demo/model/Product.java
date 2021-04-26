package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


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



    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="product_category", joinColumns={@JoinColumn(referencedColumnName="id")}
            , inverseJoinColumns={@JoinColumn(referencedColumnName="id")})
    private List<Category> product_category;

    public Product(){}

    public Product(String name, Long price, String description, String imageURL, Long quantity, List<Category> product_category){
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageURL = imageURL;
        this.quantity = quantity;
        this.product_category = product_category;

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


    public Long getId() {
        return id;
    }


    public Long getPrice() {
        return price;
    }


    public List<Category> getCategory() {
        return product_category;
    }

    public void setCategory(List<Category> product_category){
        this.product_category = product_category;
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
}
