package com.example.refrigeratorapp;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;

// This class, SubmitManager, is used to store a single InventoryItem in the database.
// SubmitManager has three fields, name, quantity, and expDate. These are the same fields needed
// to create an InventoryItem object. The SubmitManager instance variables should be populated with
// data from the user. With this data, an InventoryItem object is created and inserted into the database.

public class SubmitManager {
    // Private fields where the name, quantity, and expiration date are stored.
    // This info can be retrieved via the appropriate "get" method
    private String name;
    private int quantity;
    private String expDate;

    // I was going to use this for a calendar object but haven't got around to it yet
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

    // Creates new SubmitManager with default fields
    public SubmitManager(){
         setName("");
         setQuantity(0);
         setExpDate("");
    }

    @SuppressLint("SetTextI18n")
    // Removes Item from the database
    // not connected to a button / not used
    public void removeItem(InventoryItem item){
        //search for item from database

        //remove item from database
    }

    // Checks to see if the name, date, or quantity are defaults, meaning the user didn't enter in one or more fields.
    // If all fields have been changed, a new InventoryItem is created with the stored info and sent to database
    @SuppressLint("SetTextI18n")
    public void submit(RefrigeratorSQLiteDBHelper db) {
        if (!getName().equals("") && !getExpDate().equals("") && !(getQuantity()==0)) {
            db.insertInventory(new InventoryItem(getName(),getQuantity(),getExpDate()));
        }
    }

    // Returns the name stored in this instance of SubmitManager
    public String getName(){
        return this.name;
    }

    // Returns the quantity stored in this instance of SubmitManager
    public int getQuantity() {
        return this.quantity;
    }

    // Returns the expiration date stored in this instance of SubmitManager
    public String getExpDate() {
        return this.expDate;
    }

    // Stores the given expiration date into this instance of SubmitManager
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    // Stores the given name into this instance of SubmitManager
    public void setName(String name) {
        this.name = name;
    }

    // Stores the given quantity into this instance of SubmitManager
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
