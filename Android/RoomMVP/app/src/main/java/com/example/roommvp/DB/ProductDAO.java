package com.example.roommvp.DB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roommvp.Model.Products;

import java.util.List;

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
