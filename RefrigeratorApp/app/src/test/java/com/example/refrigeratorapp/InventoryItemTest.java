package com.example.refrigeratorapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryItemTest {

    @Test
    public void getProductName() {
        InventoryItem test = new InventoryItem("test", 3, "01/10");
        assertTrue(test.getProductName() == "test");
    }

    @Test
    public void getCount() {
        InventoryItem test = new InventoryItem("test", 3, "01/10");
        assertTrue(test.getCount() == 3);
    }

    @Test
    public void getExpiryDate() {
        InventoryItem test = new InventoryItem("test", 3, "01/10");
        assertTrue(test.getExpiryDate() == "01/10");
    }

    @Test
    public  void isEqual() {
        InventoryItem test = new InventoryItem("test", 3, "01/10");
        InventoryItem test2 = new InventoryItem( "test2", 3, "01/10");
        assertFalse(test.isEqual(test2));
    }
}