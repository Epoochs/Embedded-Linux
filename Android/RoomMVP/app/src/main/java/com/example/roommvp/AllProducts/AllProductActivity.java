package com.example.roommvp.AllProducts;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roommvp.Model.Products;
import com.example.roommvp.R;

import java.util.ArrayList;
import java.util.List;

public class AllProductActivity extends AppCompatActivity implements OnProductClickListener, AllProView {

    RecyclerView ProrecyclerView;
    AllProductAdapter allProductAdapter;
    AllProPresenter allProPresenter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_product);

        ProrecyclerView = findViewById(R.id.AllProRecycleView);

        /* Initiate the RecycleView */
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        ProrecyclerView.setLayoutManager(layoutManager);
        allProductAdapter = new AllProductAdapter(this, new ArrayList<Products>(), this);
        ProrecyclerView.setAdapter(allProductAdapter);

        allProPresenter = new AllProPresenter(this,this);
    }

    @Override
    public void onFavClick(Products products) {
        allProPresenter.addProduct(products);
    }

    @Override
    public void showData(List<Products> products) {
        System.out.println("Success, number of products: " + products.size());
        System.out.println("Success");
        allProductAdapter.setList(products);
        allProductAdapter.notifyDataSetChanged();
    }
}