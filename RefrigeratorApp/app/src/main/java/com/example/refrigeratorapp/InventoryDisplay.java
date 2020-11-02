package com.example.refrigeratorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InventoryDisplay extends AppCompatActivity {

    TextView nameBox;
    TextView quantityBox;
    TextView expBox;

    private SubmitManager sm =  new SubmitManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_display);
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

    public void addButton(View view){
        nameBox = findViewById(R.id.nameBox);
        quantityBox = findViewById(R.id.QuantityBox);
        expBox = findViewById(R.id.ExpirationBox);
        sm.setName(nameBox.getText().toString());
        sm.setQuantity(Integer.parseInt(quantityBox.getText().toString()));
        sm.setExpDate(expBox.getText().toString());
        sm.submit();
        removeFragment();
    }

}