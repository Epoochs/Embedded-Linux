package com.example.roommvp.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roommvp.Model.Products;

@Database(entities = {Products.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    private static ProductDatabase productDatabase = null;

    public abstract ProductDAO getProductDAO();

    public static synchronized ProductDatabase getInstance(Context context) {
        if (productDatabase == null) {
            productDatabase = Room.databaseBuilder(context.getApplicationContext(), ProductDatabase.class, "productsdp").build();

        }
        return productDatabase;
    }
}
