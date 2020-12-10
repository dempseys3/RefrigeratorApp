package com.example.refrigeratorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class InventoryDisplay extends AppCompatActivity {

    // EditText boxes that are used to enter item info. Updated in addButton()
    EditText nameBox;
    EditText quantityBox;
    EditText expBox;

    // Instance of SubmitManager
    private SubmitManager sm =  new SubmitManager();

    //New Stuff for Recycler View
    private RefrigeratorSQLiteDBHelper mDatabase;
    private ItemAdapter mAdapter;
    private ContactAdapter ca;
    private ArrayList<InventoryItem> allItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_display);

        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        recList.setLayoutManager(llm);
        recList.setHasFixedSize(true);
        mDatabase = new RefrigeratorSQLiteDBHelper(this);
        allItems = mDatabase.getInventory();

        if(allItems.size() > 0){
            recList.setVisibility(View.VISIBLE);
            ContactAdapter ca = new ContactAdapter(allItems);
            //mAdapter = new ItemAdapter(this, allItems);
            recList.setAdapter(ca);

        }else {
            recList.setVisibility(View.GONE);
            Toast.makeText(this, "There is no item in the inventory. Start adding now", Toast.LENGTH_LONG).show();
        }

        findViewById(R.id.ADD_BUTTON).setVisibility(View.INVISIBLE);


    }

    // Places the "Add Item" fragment into the Scene
    public void addPopUp(View view){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction xact = fm.beginTransaction();
        if(null == fm.findFragmentByTag("AddTag")){
            xact.add(R.id.fragmentContainer,new AddFragment(), "AddTag").commit();
        }
        // Makes the "ADD" button visible
        Button btn = findViewById(R.id.ADD_BUTTON);
        btn.setVisibility(View.VISIBLE);
    }

    // Removes the "Add Item" fragment from the Scene
    public void removeFragment(){
        Fragment frag = getSupportFragmentManager().findFragmentByTag("AddTag");
        if(frag!=null){
            getSupportFragmentManager().beginTransaction().remove(frag).commit();
        }
        // Makes the "ADD" button invisible
        Button btn = findViewById(R.id.ADD_BUTTON);
        btn.setVisibility(View.INVISIBLE);
    }

    // Updates the RecyclerView, contactView, with the most recent list from the database.
    // I just copied and pasted this from the OnCreate method so it may not be very efficient
    public void updateRecycler(){
        allItems = mDatabase.getInventory();
        RecyclerView contactView = (RecyclerView)findViewById(R.id.product_list);

        if(allItems.size() > 0){
            contactView.setVisibility(View.VISIBLE);
            mAdapter = new ItemAdapter(this, allItems);
            contactView.setAdapter(mAdapter);


        }else {
            contactView.setVisibility(View.GONE);
            Toast.makeText(this, "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
        }
    }


    // Called when ADD button is pressed.
    public void addButton(View view){
        // These are the EditText boxes that the user enters the item info
        nameBox = findViewById(R.id.nameBox);
        quantityBox = findViewById(R.id.QuantityBox);
        expBox = findViewById(R.id.ExpirationBox);

        // If any of the following "set" methods fail because there was no text in the EditText,
        // it should just close the fragment without submitting anything
        try{
            // Stores the name, quantity, and expiration date to sm (SubmitManager)
            sm.setName(nameBox.getText().toString());
            sm.setQuantity(Integer.parseInt(quantityBox.getText().toString()));
            sm.setExpDate(expBox.getText().toString());
            sm.submit(mDatabase);
            // Updates the recyclerView with the new item
            updateRecycler();
            // Removes the pop-up screen where you can enter item info
            removeFragment();
        }
        catch(Exception e){
            // Removes the pop-up screen where you can enter item info
            removeFragment();
        }

        // Sets the sm fields back to default to check for unentered fields
        sm.setExpDate("");
        sm.setName("");
        sm.setQuantity(0);
    }


}