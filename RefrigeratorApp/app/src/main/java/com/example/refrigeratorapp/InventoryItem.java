package com.example.refrigeratorapp;

public class InventoryItem {
    private String productName;
    private int count;
    private String expiryDate;

    public InventoryItem(String productName, int count, String expiryDate) {
        this.productName = productName;
        this.expiryDate = expiryDate;
        this.count = count;
    }


    String getProductName(){
        return productName;
    }

    int getCount(){
        return count;
    }

    String getExpiryDate(){
        return expiryDate;
    }

}
