package com.example.refrigeratorapp;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SubmitManager {

    private ArrayList<InventoryItem> itemArray = new ArrayList<>();
    //RefrigeratorSQLiteDBHelper db = new RefrigeratorSQLiteDBHelper();
    //itemArray = db.getInventory();

    private String name;
    private int quantity;
    private String expDate;
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");


    public SubmitManager(){
         setName("name");
         setQuantity(1);
         setExpDate("11/11/1111");
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
        for(int i = 0; i < itemArray.size(); i++){
            if(item.isEqual(itemArray.get(i))){
                itemArray.remove(i);
                return;
            }
        }
    }

    @SuppressLint("SetTextI18n")
    // Adds new Item to itemArray and displays success or fail message
    public void addItem(String name, String expDate, int count){
        itemArray.add(new InventoryItem(name,count,expDate));
    }

    @SuppressLint("SetTextI18n")
    public void submit() {
        if (!name.equals("") && !expDate.equals("")) {
            addItem(getName(), getExpDate(), getQuantity());
        }
    }

    public String getName(){
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getExpDate() {
        return expDate;
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

//    public Calendar stringToDate(){
//
//    }

    public String dateToString(Calendar c){
        return simpleDateFormat.format(c.getTime());
    }

    public ArrayList<InventoryItem> getItemArray(){
        return this.itemArray;
    }
}
