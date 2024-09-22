package com.example.listview;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private Vector<MyItems> myItems = new Vector<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        myItems.add(new MyItems(R.mipmap.one, "One"));
        myItems.add(new MyItems(R.mipmap.two, "Two"));
        myItems.add(new MyItems(R.mipmap.three, "Three"));
        myItems.add(new MyItems(R.mipmap.four, "Four"));
        myItems.add(new MyItems(R.mipmap.five, "Five"));
        myItems.add(new MyItems(R.mipmap.six, "Six"));
        myItems.add(new MyItems(R.mipmap.seven, "Seven"));

        listView = findViewById(R.id.lvListView);

        ItemArrayAdapter adapter = new ItemArrayAdapter(this,R.layout.row,R.id.tvIconName,myItems);
        listView.setAdapter(adapter);
    }
}