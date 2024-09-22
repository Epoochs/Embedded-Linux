package com.example.room.Model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.room.db.ProductDAO;
import com.example.room.db.ProductDatabase;

import java.util.List;

public class Repository {
    private static Repository repository = null;
    //private List<Products> productsList;
    private LiveData<List<Products>> productsList;
    ProductDAO productDAO;

    private Repository(Context context){
        ProductDatabase database = ProductDatabase.getInstance(context.getApplicationContext());
        productDAO = database.getProductDAO();
        /*new Thread(){
            @Override
            public void run() {
                productsList = productDAO.getAllProducts();
            }
        }.start();*/
        productsList = productDAO.getAllProducts();
    }


    /*public  List<Products> getProductsList(){
        return productsList;
    }*/

    public  LiveData<List<Products>> getProductsList(){
        return productsList;
    }

    public static Repository getInstance(Context context){
        if(repository == null){
            repository = new Repository(context);
        }
        return repository;
    }

    public void addProduct(Products product){
        new Thread(){
            public void run(){
                productDAO.insertProduct(product);
                //productsList.add(product);
            }
        }.start();
    }

    public void removeProduct(Products product){
        new Thread(){
            public void run(){
                productDAO.deleteProduct(product);
                //productsList.remove(product);
            }
        }.start();
    }
}
