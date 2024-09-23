package com.example.roommvp.FavProducts;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.roommvp.DB.ProductDAO;
import com.example.roommvp.DB.ProductDatabase;
import com.example.roommvp.Model.Products;
import com.example.roommvp.Model.Repository;

import java.util.List;

public class FavProPresenter{
    Context context;
    FavProView favProView;
    Repository repository;
    LiveData<List<Products>> myProducts;
    public static FavProPresenter favProPresenter;

    public FavProPresenter(Context context, FavProView favProView){
        this.context = context;
        this.favProView = favProView;
        repository = Repository.getInstance(context);
    }

    public static void getInstance(Context context, FavProView favProView){
        if(favProPresenter == null){
            favProPresenter = new FavProPresenter(context, favProView);
        }
    }

    public void getData(){
        myProducts = repository.getProductsList();
    }

    public void deleteProduct(Products products){
        repository.removeProduct(products);
    }
}
