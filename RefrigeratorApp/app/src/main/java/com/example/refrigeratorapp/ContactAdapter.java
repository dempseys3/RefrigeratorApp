package com.example.refrigeratorapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private ArrayList<InventoryItem> contactList;

    public ContactAdapter(ArrayList<InventoryItem> contactList) {
        this.contactList = contactList;
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        InventoryItem ci = contactList.get(i);
        contactViewHolder.vName.setText(ci.getProductName());
        contactViewHolder.vExp.setText("Expiry Date: " + ci.getExpiryDate());
        contactViewHolder.vQuant.setText("Quantity: " +ci.getCount());



    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_view_activity, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vExp;
        protected TextView vQuant;

        public ContactViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.title);
            vExp = (TextView) v.findViewById(R.id.expiry);
            vQuant = (TextView) v.findViewById(R.id.quantity);
        }
    }
}