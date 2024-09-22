package com.example.room.FavProducts;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.example.room.Model.Products;
import com.example.room.Model.Repository;
import com.example.room.R;
import com.example.room.db.ProductDAO;
import com.example.room.db.ProductDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FavActivity extends AppCompatActivity implements OnFavClickListener{

    RecyclerView favRecycleView;
    FavAdapter favAdapter;
    LinearLayoutManager layoutManager;
    Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fav);

        /* Fav recycle view reference */
        favRecycleView = findViewById(R.id.FavRecycleView);

        /* Instance of the repo */
        repo = Repository.getInstance(this);

        /* Init the recycle View */
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        favRecycleView.setLayoutManager(layoutManager);
        // favAdapter = new FavAdapter(this, repo.getProductsList(),this);
        favAdapter = new FavAdapter(this, new ArrayList<>(),this);
        favRecycleView.setAdapter(favAdapter);

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
    public void onDeleteClick(Products product) {
        repo.removeProduct(product);
        /*favAdapter.setList(repo.getProductsList());
        favAdapter.notifyDataSetChanged();*/
        Toast.makeText(FavActivity.this, "Product deleted", Toast.LENGTH_SHORT).show();
    }
}