package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private List<Products> pro;
    private TextView tvTitle, tvPrice, tvBrand, tvDescription, tvRating;
    private ImageView imageView;
    private Button btnNext, btnPrev;
    private RatingBar ratingBar;
    private int currentProduct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        /* Getting reference of the View Components IDs */
        tvTitle = findViewById(R.id.tvTitleVal);
        tvPrice = findViewById(R.id.tvPriceVal);
        tvBrand = findViewById(R.id.tvBrandVal);
        tvDescription = findViewById(R.id.tvDescriptionVal);
        ratingBar = findViewById(R.id.ratingBar);
        btnNext = findViewById(R.id.btnNxt);
        btnPrev = findViewById(R.id.btnPrev);
        imageView = findViewById(R.id.imageView);

        /* Handler to modify on the main Thread from the connection thread, Display the first Product */
        Handler handler = new Handler(Looper.getMainLooper()){
            @SuppressLint("StaticFieldLeak")
            @Override
            public void handleMessage(Message msg){
                tvTitle.setText(pro.get(0).getTitle());
                tvPrice.setText(String.valueOf(pro.get(0).getPrice()));
                tvBrand.setText(pro.get(0).getBrand());
                tvDescription.setText(pro.get(0).getDescription());
                ratingBar.setRating((float) pro.get(0).getRatings());
                Glide.with(MainActivity.this).load(pro.get(0).getImgURL()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground).into(imageView);
            }
        };


        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://dummyjson.com/").build();

        Pro pro1 = retrofit.create(Pro.class);
        Call<ProductResponse> call = pro1.getProduct();
        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                pro = response.body().getProducts();
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable throwable) {
                System.out.println("--");
                throwable.printStackTrace();
            }
        });

        /* Next Button handling */
        btnNext.setOnClickListener(v -> {
            if(currentProduct == 15) {
                currentProduct = 0;
                tvTitle.setText(pro.get(currentProduct).getTitle());
                tvPrice.setText(String.valueOf(pro.get(currentProduct).getPrice()));
                tvBrand.setText(pro.get(currentProduct).getBrand());
                tvDescription.setText(pro.get(currentProduct).getDescription());
                ratingBar.setRating((float) pro.get(currentProduct).getRatings());
                Glide.with(MainActivity.this).load(pro.get(currentProduct).getImgURL()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground).into(imageView);
            }else {
                currentProduct++;
                tvTitle.setText(pro.get(currentProduct).getTitle());
                tvPrice.setText(String.valueOf(pro.get(currentProduct).getPrice()));
                tvBrand.setText(pro.get(currentProduct).getBrand());
                tvDescription.setText(pro.get(currentProduct).getDescription());
                ratingBar.setRating((float) pro.get(currentProduct).getRatings());
                Glide.with(MainActivity.this).load(pro.get(currentProduct).getImgURL()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground).into(imageView);
            }
        });
        /* Prev Button Handling */
        btnPrev.setOnClickListener(v -> {
            if(currentProduct > 0) {
                currentProduct--;
                tvTitle.setText(pro.get(currentProduct).getTitle());
                tvPrice.setText(String.valueOf(pro.get(currentProduct).getPrice()));
                tvBrand.setText(pro.get(currentProduct).getBrand());
                tvDescription.setText(pro.get(currentProduct).getDescription());
                ratingBar.setRating((float) pro.get(currentProduct).getRatings());
                Glide.with(MainActivity.this).load(pro.get(currentProduct).getImgURL()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground).into(imageView);
            }else{
                currentProduct = 15;
                tvTitle.setText(pro.get(currentProduct).getTitle());
                tvPrice.setText(String.valueOf(pro.get(currentProduct).getPrice()));
                tvBrand.setText(pro.get(currentProduct).getBrand());
                tvDescription.setText(pro.get(currentProduct).getDescription());
                ratingBar.setRating((float) pro.get(currentProduct).getRatings());
                Glide.with(MainActivity.this).load(pro.get(currentProduct).getImgURL()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground).into(imageView);
            }
        });
    }
}