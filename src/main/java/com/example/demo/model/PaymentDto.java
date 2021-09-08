package com.example.demo.model;

public class PaymentDto {
    private String reference;
    private long amount;

    public PaymentDto(String reference, long amount){
        this.reference = reference;
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public String getReference() {
        return reference;
    }
}
