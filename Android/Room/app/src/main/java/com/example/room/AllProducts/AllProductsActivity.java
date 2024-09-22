package com.example.room.AllProducts;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.room.Model.Products;
import com.example.room.Model.Repository;
import com.example.room.Networking.Client;
import com.example.room.Networking.NetworkCallback;
import com.example.room.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AllProductsActivity extends AppCompatActivity implements OnProductClickListener, NetworkCallback {

    RecyclerView ProrecyclerView;
    AllProductAdapter allProductAdapter;
    LinearLayoutManager layoutManager;
    Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* Setting the start of the application */
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_products);

        /* Testing */
        /*Vector<Products> sampleData = new Vector<>();
        sampleData.add(new Products("Ahmed",12,"Nike","ddew", 23.12,""));
        sampleData.add(new Products("Ah",12,"Nike","ddew", 23.12,""));*/

        /* RecycleView Reference */
        ProrecyclerView = findViewById(R.id.ProRecycleView);

        /* Initiate the RecycleView */
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        ProrecyclerView.setLayoutManager(layoutManager);
        allProductAdapter = new AllProductAdapter(this, new ArrayList<Products>(), this);
        ProrecyclerView.setAdapter(allProductAdapter);
        System.out.println("Iam After Adapter being init");

        /* Start Connection to get the data */
        Client c = Client.getInstance();
        c.makeNetworkCallback(this);
        System.out.println("Iam After Client being init");

        /* Get Instance of Repository */
        repo = Repository.getInstance(this);
    }

    @Override
    public void onFavClick(Products product) {
        System.out.println("ADDED");
        Toast.makeText(AllProductsActivity.this, "Added", Toast.LENGTH_SHORT).show();
        repo.addProduct(product);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onSuccessResult(List<Products> products) {
        System.out.println("Success, number of products: " + products.size());
        System.out.println("Success");
        allProductAdapter.setList(products);
        allProductAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFalureResult(String str) {
        System.out.println("Fail");
        Toast.makeText(AllProductsActivity.this, "Failed: " + str, Toast.LENGTH_SHORT).show();
    }
}