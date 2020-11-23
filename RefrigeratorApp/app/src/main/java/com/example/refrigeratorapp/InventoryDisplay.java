package com.example.refrigeratorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InventoryDisplay extends AppCompatActivity {

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
            Toast.makeText(this, "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
        }










        //New Stuff for Recycler View
        //ConstraintLayout CLayout = (ConstraintLayout) findViewById(R.id.activity_to_do);
        /*RecyclerView contactView = (RecyclerView)findViewById(R.id.product_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        contactView.setLayoutManager(linearLayoutManager);
        contactView.setHasFixedSize(true);
        mDatabase = new RefrigeratorSQLiteDBHelper(this);
        allItems = mDatabase.getInventory();

        if(allItems.size() > 0){
            contactView.setVisibility(View.VISIBLE);
            mAdapter = new ItemAdapter(this, allItems);
            contactView.setAdapter(mAdapter);

        }else {
            contactView.setVisibility(View.GONE);
            Toast.makeText(this, "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
        }*/



    }

}