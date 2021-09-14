package com.example.demo.presentation;


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

//Osäkert om denna klass behövs framöver