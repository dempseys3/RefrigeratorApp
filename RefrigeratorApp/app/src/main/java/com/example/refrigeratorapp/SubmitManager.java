package com.example.refrigeratorapp;

import android.annotation.SuppressLint;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SubmitManager {

    private ArrayList<InventoryItem> itemArray = new ArrayList<>();
    //RefrigeratorSQLiteDBHelper db = new RefrigeratorSQLiteDBHelper();
    //itemArray = db.getInventory();

    private String name;
    private int quantity;
    private String expDate;
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");


    public SubmitManager(){
         setName("");
         setQuantity(0);
         setExpDate("");
    }

    public SubmitManager(TextView nameBox, TextView quantityBox, TextView expBox){
        setName(nameBox.getText().toString());
        setQuantity(Integer.parseInt(quantityBox.getText().toString()));
        setExpDate(expBox.getText().toString());
    }

    @SuppressLint("SetTextI18n")
    // Removes Item from the itemArray
    // not connected to a button / not used
    public void removeItem(InventoryItem item){
        //search for item from database

        //remove item from database
    }

    @SuppressLint("SetTextI18n")
    // Adds new Item to itemArray and displays success or fail message
    public void addItem(String name, String expDate, int count){
        itemArray.add(new InventoryItem(name,count,expDate));
    }

    @SuppressLint("SetTextI18n")
    public void submit(RefrigeratorSQLiteDBHelper db) {
        if (!getName().equals("") && !getExpDate().equals("") && !(getQuantity()==0)) {
            db.insertInventory(new InventoryItem(getName(),getQuantity(),getExpDate()));
        }
    }

    public String getName(){
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getExpDate() {
        return this.expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
