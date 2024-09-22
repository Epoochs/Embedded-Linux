package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.room.AllProducts.AllProductsActivity;
import com.example.room.AllProducts.AllProductAdapter;
import com.example.room.FavProducts.FavActivity;
import com.example.room.Model.Products;
import com.example.room.Networking.Client;
import com.example.room.Networking.NetworkCallback;
import com.example.room.db.ProductDAO;
import com.example.room.db.ProductDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnFav, btnPro, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ProductDatabase productDatabase = ProductDatabase.getInstance(this);

    /*    new Thread(){
            @Override
            public void run() {
                super.run();
                productDatabase.getProductDAO().deleteProduct(new Products("PpN",45,"Roto","Good Pen", 64.0,"mesa.com"));
            }
        }.start(); */

        /* Button-View References */
        btnPro = findViewById(R.id.btnAllProducts);
        btnFav = findViewById(R.id.btnFav);
        btnExit = findViewById(R.id.btnEX);

        /* Buttons' Handling */
        btnPro.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AllProductsActivity.class);
            startActivity(intent);
        });
        btnFav.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FavActivity.class);
            startActivity(intent);
        });
        btnExit.setOnClickListener(v -> {
            finish();
        });
    }
}