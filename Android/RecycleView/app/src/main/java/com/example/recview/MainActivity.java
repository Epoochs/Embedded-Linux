package com.example.recview;

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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private Vector<Products> pro = new Vector<>();
    private RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        /* Handler to modify on the main Thread from the connection thread, Display the first Product */
        Handler handler = new Handler(Looper.getMainLooper()){
            @SuppressLint("StaticFieldLeak")
            @Override
            public void handleMessage(Message msg){
                /* Getting reference of the RecyclerView and Configuring the layout */
                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                layoutManager.setOrientation(RecyclerView.HORIZONTAL);
                recyclerView.setLayoutManager(layoutManager);
                MyAdapter adapter = new MyAdapter(MainActivity.this, pro);
                recyclerView.setAdapter(adapter);
            }
        };


       new Thread() {
            public void run() {
                HttpHandler ht = new HttpHandler();
                String strJSON = ht.getConnect("https://dummyjson.com/products");
                try {
                    JSONObject jsonObject = new JSONObject(strJSON);
                    JSONArray jsonArray = jsonObject.getJSONArray("products");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObjectTemp = jsonArray.getJSONObject(i);
                        System.out.println(i);
                        pro.add(new Products());
                        pro.get(i).setTitle(jsonObjectTemp.getString("title"));
                        pro.get(i).setPrice(jsonObjectTemp.getInt("price"));
                        pro.get(i).setBrand(jsonObjectTemp.getString("brand"));
                        pro.get(i).setDescription(jsonObjectTemp.getString("description"));
                        pro.get(i).setRatings(jsonObjectTemp.getDouble("rating"));
                        pro.get(i).setImgURL(jsonObjectTemp.getString("thumbnail"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(0);
            }
        }.start();
    }
}