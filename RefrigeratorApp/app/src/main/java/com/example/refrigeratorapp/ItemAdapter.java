package com.example.refrigeratorapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    @NonNull
    private Context context;
    private ArrayList<Item> listItems;
    private ArrayList<Item> mArrayList;
    private RefrigeratorSQLiteDBHelper refrigeratorDatabase;

    public ItemAdapter(Context context, ArrayList<Item> listItems) {
        this.context = context;
        this.listItems = listItems;
        this.mArrayList=listItems;
        refrigeratorDatabase = new RefrigeratorSQLiteDBHelper(context);
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Item items = listItems.get(position);
        holder.name.setText(items.getName());

    }

    @Override
    public int getItemCount() {

        return listItems.size();
    }
}
