package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String address;
    private Long sum;



/*    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "order_row", joinColumns = {@JoinColumn(referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private List<Customer> order_row_customer;*/



    @JoinColumn
    @ManyToOne
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders", orphanRemoval = true)
    @JsonBackReference
    private Set<Order_Row> order_row;

    @CreationTimestamp
    @Column(name = "dataoforder")
    private LocalDateTime createDate;



    public Orders(){}

    public Orders(Long id, String address, Customer customer, Long sum) {
        this.id = id;
        this.address = address;
        this.customer = customer;
        this.sum = sum;
    }

    public Orders(String address, Customer customer, Long sum) {
        this.address = address;
        this.customer = customer;
        this.sum = sum;

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Order_Row> getOrder_row() {
        return order_row;
    }

    public void setOrder_row(Set<Order_Row> order_row) {
        this.order_row = order_row;
    }
}
