package com.example.refrigeratorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

public class submitScene extends AppCompatActivity {
    private fragmentTest fragTest;
    private ArrayList<Item> itemArray = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_scene);



    }
    public void addPopUp(View view){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction xact = fm.beginTransaction();
        if(null == fm.findFragmentByTag("AddTag")){
            xact.add(R.id.fragmentContainer,new AddFragment(), "AddTag").commit();
        }
        Button btn = findViewById(R.id.button3);
        btn.setVisibility(View.VISIBLE);
    }

    @SuppressLint("SetTextI18n")
    // Adds new Item to itemArray and displays success or fail message
    public void addItem(String name, String expDate){
        TextView lastItem = findViewById(R.id.textView3);
       Item test = new Item(name, expDate);
       if(test.dateCheck(test)){
           itemArray.add(new Item(name,expDate));
           lastItem.setText(itemArray.get(itemArray.size()-1).getName() + " added to fridge");
       }
       else{
           lastItem.setText("Invalid date");
       }
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
    public void removeFragment(){
        Fragment frag = getSupportFragmentManager().findFragmentByTag("AddTag");
        if(frag!=null){
            getSupportFragmentManager().beginTransaction().remove(frag).commit();
        }
        Button btn = findViewById(R.id.button3);
        btn.setVisibility(View.INVISIBLE);
    }


    @SuppressLint("SetTextI18n")
    // Calls addItem()
    public void submit(View view) {
        EditText foodItemBox = findViewById(R.id.nameBox);
        String name = foodItemBox.getText().toString();
        EditText foodExpBox = findViewById(R.id.ExpirationBox);
        String expDate = foodExpBox.getText().toString();
        TextView textview = findViewById(R.id.textView9);
        if (!name.equals("") && !expDate.equals("")) {
            addItem(name, expDate);
            textview.setText(itemArray.size() + " items in fridge");
        }
        removeFragment();
        Button btn = findViewById(R.id.button3);
    }

    // Displays specified item from itemArray, only used to show that the items are actually stored

    @SuppressLint("SetTextI18n")
    public void showItem(View view){
        EditText itemNumBox = findViewById(R.id.itemNumBox);
        TextView nameView = findViewById(R.id.nameTextView);
        TextView exp = findViewById(R.id.expTextView);
        String s = itemNumBox.getText().toString();
        int numOfItem = Integer.parseInt(s);
        if(itemArray.size()>0 && numOfItem<=itemArray.size()-1 && numOfItem>=0){
            nameView.setText(itemArray.get(numOfItem).getName());
            exp.setText(itemArray.get(numOfItem).getExpDate().get(Calendar.MONTH) + "/" + itemArray.get(numOfItem).getExpDate().get(Calendar.DAY_OF_MONTH) + "/" +
                    itemArray.get(numOfItem).getExpDate().get(Calendar.YEAR));
        }
    }

    // Pressing the back button returns user to Main Activity
    public void goToMain(View view){
        finish();
    }
}
