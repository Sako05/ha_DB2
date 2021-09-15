package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String reference; //OrderID
    private String status;

    public Payment() {
        //For hibernate
    }

    public Payment(long id, String reference, String status) {
        this.id = id;
        this.reference = reference;
        this.status = status;
    }

    public Payment(String reference, String status) {
        this.reference = reference;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) { this.status = status; }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
