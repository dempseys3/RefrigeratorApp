package com.example.refrigeratorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InventoryDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_display);


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

}