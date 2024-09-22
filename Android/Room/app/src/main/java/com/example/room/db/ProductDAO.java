package com.example.room.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.room.Model.Products;

import java.util.List;
import java.util.Vector;

@Dao
public interface ProductDAO {
    @Query("SELECT * FROM products_table")
    //List<Products> getAllProducts();
    LiveData<List<Products>> getAllProducts();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertProduct(Products products);

    @Delete
    void deleteProduct(Products products);
}
