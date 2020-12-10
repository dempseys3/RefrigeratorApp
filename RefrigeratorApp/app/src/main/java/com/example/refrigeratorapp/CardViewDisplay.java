package com.example.refrigeratorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CardViewDisplay extends AppCompatActivity {
    Button decreaseButton;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view_activity);
        decreaseButton = (Button) findViewById(R.id.displayButton);
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, InventoryDisplay.class);
        startActivity(intent);
    }
}
