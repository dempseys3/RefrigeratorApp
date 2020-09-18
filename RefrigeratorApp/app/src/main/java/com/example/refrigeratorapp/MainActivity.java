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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Starts activity in which user can add to and view the contents of the fridge
    public void goToSubmit(View view){
        Intent intent = new Intent(MainActivity.this, submitScene.class);
        startActivity(intent);
    }
}