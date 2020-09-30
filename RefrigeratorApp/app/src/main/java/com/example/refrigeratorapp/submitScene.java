package com.example.refrigeratorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class submitScene extends AppCompatActivity {
    private ArrayList<Item> itemArray = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_scene);


    }

    @SuppressLint("SetTextI18n")
    // Adds new Item to itemArray and displays success or fail message
    public void addItem(String name, String expDate){
        TextView lastItem = findViewById(R.id.textView3);
       // Item test = new Item("test", expDate);
       // lastItem.setText(name + " " + expDate);
        
        itemArray.add(new Item(name,expDate));
        lastItem.setText(itemArray.get(itemArray.size()-1).getName() + " added to fridge");


    }
    @SuppressLint("SetTextI18n")
    // Removes Item from the itemArray
    // not connected to a button / not used
    public void removeItem(Item item){
        TextView lastItem = findViewById(R.id.textView3);
        for(int i = 0; i < itemArray.size(); i++){
            if(item.isEqual(itemArray.get(i))){
                itemArray.remove(i);
                lastItem.setText(itemArray.get(i).getName() + " was removed");
                return;
            }
        }
        lastItem.setText("Could not remove item");
    }


    @SuppressLint("SetTextI18n")
    // Calls addItem()
    public void submit(View view){
        EditText foodItemBox = findViewById(R.id.foodItemBox);
        String name = foodItemBox.getText().toString();
        EditText foodExpBox = findViewById(R.id.foodExpBox);
        String expDate = foodExpBox.getText().toString();
        if(!name.equals("") || !expDate.equals("")){
            addItem(name, expDate);
        }

    }

    // Pressing the back button returns user to Main Activity
    public void goToMain(View view){
        finish();
    }
}
