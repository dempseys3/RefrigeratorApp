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

    Boolean isEqual(InventoryItem item){
        if(this.productName == item.productName && this.expiryDate == item.expiryDate){
            return true;
        }else{
            return false;
        }
    }

}
