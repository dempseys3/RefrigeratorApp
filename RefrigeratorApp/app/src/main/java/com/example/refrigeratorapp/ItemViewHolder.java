package com.example.refrigeratorapp;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public TextView name;


    public ItemViewHolder(View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.item_name);
    }
}