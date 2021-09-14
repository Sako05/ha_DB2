package com.example.demo.model;


public class Payment {

    private long amount;
    private String reference;
    private String status;

    public Payment() {
        //For hibernate
    }

    public Payment(String reference, String status) {
        this.reference = reference;
        this.status = status;
    }

    public String getReference() {
        return reference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) { this.status = status; }
}
