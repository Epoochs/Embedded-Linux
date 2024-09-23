package com.example.roommvp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.roommvp.AllProducts.AllProductActivity;
import com.example.roommvp.FavProducts.FavActivity;

public class MainActivity extends AppCompatActivity {

    Button btnFav, btnPro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnFav = findViewById(R.id.btnFav);
        btnPro = findViewById(R.id.btnAllProducts);

        /* Buttons' Handling */
        btnPro.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AllProductActivity.class);
            startActivity(intent);
        });
        btnFav.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FavActivity.class);
            startActivity(intent);
        });
    }
}