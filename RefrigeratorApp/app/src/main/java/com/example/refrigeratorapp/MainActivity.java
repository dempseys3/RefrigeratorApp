package com.example.refrigeratorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button displayButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // code create button that displays inventory
        displayButton = (Button) findViewById(R.id.displayButton);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });


    }


    // Starts activity in which user can add to and view the contents of the fridge
    public void goToSubmit(View view){
        Intent intent = new Intent(MainActivity.this, submitScene.class);
        startActivity(intent);
    }
    
    //Code to open page with inventory
    public void openNewActivity(){
        Intent intent = new Intent(this, InventoryDisplay.class);
        startActivity(intent);
    }


}