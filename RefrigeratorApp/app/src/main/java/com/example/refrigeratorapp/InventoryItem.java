package com.example.refrigeratorapp;

public class InventoryItem {
    private int id;
    private String productName;
    private int count;
    private String expiryDate;

    public InventoryItem(String productName, int count, String expiryDate) {
        this.productName = productName;
        this.expiryDate = expiryDate;
        this.count = count;
    }

    public InventoryItem(int id, String productName, int count, String expiryDate) {
        this.id = id;
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

    int getId() {return id;}

    Boolean isEqual(InventoryItem item){
        if(this.productName == item.productName && this.expiryDate == item.expiryDate){
            return true;
        }else{
            return false;
        }
    }

}
