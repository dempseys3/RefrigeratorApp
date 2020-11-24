package com.example.refrigeratorapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// This class creates a fragment, AddFragment, which displays fragment_add.xml. This screen has three EditTexts
// on it, each labeled. These EditTexts on fragment_add.xml are where the user enters the info needed to create
// an InventoryItem object. When the needed info has been received, the fragment should close.
public class AddFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);

    }
}