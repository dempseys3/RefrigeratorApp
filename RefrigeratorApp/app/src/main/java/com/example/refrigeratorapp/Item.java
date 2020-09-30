package com.example.refrigeratorapp;

import android.view.View;

import java.util.Calendar;
import java.util.Date;

public class Item {
    // Item instance variables
    private String name;
    private Calendar expDate;

    // Item constructors
    public Item(){
        this.name = "food Item";
        this.expDate = Calendar.getFood();
        this.expDate.set(11,11,1111);
    }

    public Item(String name, Calendar expDate){
        this.name = name;
        this.expDate = expDate;
    }

    public Item(String name, String expDate){
        this.name = name;
        int[] dateArr = dateSeparator(expDate);
        this.expDate = Calendar.getInstance();
        this.expDate.set(dateArr[2],dateArr[0],dateArr[1]);
    }

    public Item(String name, int year, int month, int day){
        this.name = name;
        this.expDate = Calendar.getInstance();
        expDate.set(year,month,day);
    }

    // Separates date String in format mm/dd/yyyy to an integer array
    public int[] dateSeparator(String date){
        String[] dateArr = (date.split("/",3));
        int[] dateArrInt = new int[3];
        // Parses String date data into integer array
        for(int i=0;i<dateArr.length;i++){
            dateArrInt[i] = Integer.parseInt(dateArr[i]);
        }
        return dateArrInt;
    }

    // Checks the validity of the date entered so that dateSeparator() gets the correct format
    // Returns 0 if invalid and 1 if valid
    //in progress
    public boolean dateCheck(Calendar date){
        return false;
    }

    // Returns the name of item
    public String getName(){
        return this.name;
    }

    // Returns the expiration date of item
    public Calendar getExpDate() {
        return expDate;
    }
    // Equals method because I always have a hard time overriding the Object.equals()
    public boolean isEqual(Item item){
        return (this.getName().equals(item.getName()) && this.getExpDate().equals(item.getExpDate()));
    }

    // Describes Item as a String
    public String toString(){
        String r = "Name: " + this.getName() + " Exp. Date: " + this.expDate.get(Calendar.MONTH) + "/"
                + this.expDate.get(Calendar.DAY_OF_MONTH) + "/" + this.expDate.get(Calendar.YEAR);
        return r;
    }
}
