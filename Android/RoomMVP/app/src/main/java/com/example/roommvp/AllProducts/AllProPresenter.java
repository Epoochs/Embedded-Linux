package com.example.roommvp.AllProducts;

import android.app.AlertDialog;
import android.content.Context;

import com.example.roommvp.Model.Products;
import com.example.roommvp.Model.Repository;
import com.example.roommvp.Networking.Client;
import com.example.roommvp.Networking.NetworkCallback;

import java.util.List;

public class AllProPresenter implements NetworkCallback {
    AllProView allProView;
    Repository repository;
    Context context;


    public AllProPresenter(Context context, AllProView allProView){
        /* Ref for each Context (To get Application context) and AllProView (To get a reference of the implementation from Activity */
        this.context = context;
        this.allProView = allProView;

        /* Make an instance of the repo to deal with database */
        repository = Repository.getInstance(context);

        /* Start the HTTP connection */
        Client client = new Client();
        client.makeNetworkCallback(this);
    }

    @Override
    public void onSuccessResult(List<Products> products) {
        /* Asking View to show the data */
        allProView.showData(products);
    }

    @Override
    public void onFalureResult(String str) {
        /* Showing an alert Message as an Indication of Connection Problem */
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Error").setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void addProduct(Products products){
        repository.addProduct(products);
    }
}
