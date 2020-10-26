package com.example.refrigeratorapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RefrigeratorSQLiteDBHelper extends SQLiteOpenHelper {
    RefrigeratorSQLiteDBHelper myHelper;
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

     void insertInventory(InventoryItem data){
        SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO " + INVENTORY_TABLE_NAME + "( " +
                data.getProductName() + " , " + data.getCount() + " , "  + data.getExpiryDate()  + ")"
        );
    }

    public List<InventoryItem> getInventory(){
        ArrayList<InventoryItem> data = new ArrayList<InventoryItem>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from " + INVENTORY_TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            String productName = res.getString(res.getColumnIndex(INVENTORY_COLUMN_PRODUCT));
            int count = res.getInt(res.getColumnIndex(INVENTORY_COLUMN_COUNT));
            String expiryDate = res.getString(res.getColumnIndex(INVENTORY_COLUMN_EXPIRY_DATE));
            InventoryItem temp = new InventoryItem(productName, count, expiryDate);
            data.add(temp);
            res.moveToNext();
        }
        return data;
    }
}
