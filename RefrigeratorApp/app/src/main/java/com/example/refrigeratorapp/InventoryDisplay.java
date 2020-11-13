package com.example.refrigeratorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class InventoryDisplay extends AppCompatActivity {

    TextView nameBox;
    TextView quantityBox;
    TextView expBox;

    private SubmitManager sm =  new SubmitManager();
    //New Stuff for Recycler View
    private RefrigeratorSQLiteDBHelper mDatabase;
    private ItemAdapter mAdapter;
    private ArrayList<InventoryItem> allItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_display);
        findViewById(R.id.ADD_BUTTON).setVisibility(View.INVISIBLE);
        //New Stuff for Recycler View
        ConstraintLayout CLayout = (ConstraintLayout) findViewById(R.id.activity_to_do);
        RecyclerView contactView = (RecyclerView)findViewById(R.id.product_list);
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
        }

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




    public void addButton(View view){
        nameBox = findViewById(R.id.nameBox);
        quantityBox = findViewById(R.id.QuantityBox);
        expBox = findViewById(R.id.ExpirationBox);
        try{
            sm.setName(nameBox.getText().toString());
            sm.setQuantity(Integer.parseInt(quantityBox.getText().toString()));
            sm.setExpDate(expBox.getText().toString());
            sm.submit(mDatabase);
            updateRecycler();
            removeFragment();
        }
        catch(Exception e){
            removeFragment();
        }
    }

}