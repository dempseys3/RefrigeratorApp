package com.example.refrigeratorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

public class submitScene extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_scene);

    }

    @SuppressLint("SetTextI18n")
    // Adds new Item to itemArray and displays success or fail message
    public void addItem(String name, String expDate, int count){
        TextView lastItem = findViewById(R.id.textView3);
       InventoryItem test = new InventoryItem(name, count, expDate);
       RefrigeratorSQLiteDBHelper db = new RefrigeratorSQLiteDBHelper(submitScene.this);
       Boolean successful = db.insertInventory(test);
       if(successful == true) {
           lastItem.setText(test.getProductName() + " added to fridge");
       }else{
           lastItem.setText("Failed to add item");
       }

    }

    //@SuppressLint("SetTextI18n")
    // Removes Item from the itemArray
    // not connected to a button / not used
    /*public void removeItem(InventoryItem item){
        TextView lastItem = findViewById(R.id.textView3);
        for(int i = 0; i < itemArray.size(); i++){
            if(item.isEqual(itemArray.get(i))){
                itemArray.remove(i);
                lastItem.setText(itemArray.get(i).getProductName() + " was removed");
                return;
            }
        }
        lastItem.setText("Could not remove item");
    }*/


    @SuppressLint("SetTextI18n")
    // Calls addItem()
    public void submit(View view) {
        EditText foodItemBox = findViewById(R.id.foodItemBox);
        String name = foodItemBox.getText().toString();
        EditText foodExpBox = findViewById(R.id.foodExpBox);
        String expDate = foodExpBox.getText().toString();
        //TextView textview = findViewById(R.id.textView9);
        if (!name.equals("") && !expDate.equals("")) {
            addItem(name, expDate, 1);
            //textview.setText(itemArray.size() + " items in fridge");
        }
    }

    // Displays specified item from itemArray, only used to show that the items are actually stored

   /* @SuppressLint("SetTextI18n")
    public void showItem(View view){
        EditText itemNumBox = findViewById(R.id.itemNumBox);
        TextView nameView = findViewById(R.id.nameTextView);
        TextView exp = findViewById(R.id.expTextView);
        String s = itemNumBox.getText().toString();
        int numOfItem = Integer.parseInt(s);
        if(itemArray.size()>0 && numOfItem<=itemArray.size()-1 && numOfItem>=0){
            nameView.setText(itemArray.get(numOfItem).getProductName());
            exp.setText(itemArray.get(numOfItem).getExpiryDate());
        }
    }*/

    // Pressing the back button returns user to Main Activity
    public void goToMain(View view){
        finish();
    }
}
