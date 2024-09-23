package com.example.roommvp.FavProducts;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roommvp.DB.ProductDAO;
import com.example.roommvp.DB.ProductDatabase;
import com.example.roommvp.Model.Products;
import com.example.roommvp.R;

import java.util.ArrayList;
import java.util.List;

public class FavActivity extends AppCompatActivity implements FavProView, OnFavClickListener {

    RecyclerView favRecycleView;
    FavAdapter favAdapter;
    FavProPresenter favProPresenter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fav);

        /* Fav recycle view reference */
        favRecycleView = findViewById(R.id.FavRecycleView);

        /* Init the recycle View */
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        favRecycleView.setLayoutManager(layoutManager);
        // favAdapter = new FavAdapter(this, repo.getProductsList(),this);
        favAdapter = new FavAdapter(this, new ArrayList<>(),this);
        favRecycleView.setAdapter(favAdapter);

        favProPresenter = new FavProPresenter(this,this);

        ProductDatabase database = ProductDatabase.getInstance(this.getApplicationContext());
        ProductDAO productDAO = database.getProductDAO();
        LiveData<List<Products>> myProducts = productDAO.getAllProducts();
        myProducts.observe(this, new Observer<List<Products>>() {
            @Override
            public void onChanged(List<Products> products) {
                favAdapter.setList(products);
                favAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showData(List<Products> products) {

    }

    @Override
    public void onDeleteClick(Products product) {
        favProPresenter.deleteProduct(product);
    }
}