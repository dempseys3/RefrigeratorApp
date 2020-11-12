package com.example.refrigeratorapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Button displayButton;

    //New Stuff for Recycler View
    private RefrigeratorSQLiteDBHelper mDatabase;
    //not sure how to go from list to array
    private List<InventoryItem> allItems = new ArrayList<>();
    private ItemAdapter mAdapter;

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