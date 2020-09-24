package com.example.refrigeratorapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RefrigeratorSQLiteDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "refrigerator_database";
    public static final String INVENTORY_TABLE_NAME = "inventory";
    public static final String INVENTORY_COLUMN_ID = "_id";
    public static final String INVENTORY_COLUMN_PRODUCT = "product";
    public static final String INVENTORY_COLUMN_COUNT = "date";
    public static final String INVENTORY_COLUMN_EXPIRY_DATE = "expiry_date";

    public RefrigeratorSQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + INVENTORY_TABLE_NAME + " (" +
                INVENTORY_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                INVENTORY_COLUMN_PRODUCT + " TEXT, " +
                INVENTORY_COLUMN_COUNT + " INT, " +
                INVENTORY_COLUMN_EXPIRY_DATE + " TEXT" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + INVENTORY_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertInventory(SQLiteDatabase sqLiteDatabase, String[] data){

        sqLiteDatabase.execSQL("INSERT INTO " + INVENTORY_TABLE_NAME + "( " +
                data[1] + " , " + data[2] + " , "  + data[3]  + ")"
        );
    }

    public String[] getInventory(SQLiteDatabase sqLiteDatabase){
        String[] data = new String[5];
        sqLiteDatabase.execSQL("SELECT * FROM " + INVENTORY_TABLE_NAME);
        return data;
    }
}
