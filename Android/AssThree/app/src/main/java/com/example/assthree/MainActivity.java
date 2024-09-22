package com.example.assthree;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int rotationCounter = 0;
    private TextView viewNumberRotation_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewNumberRotation_tv = findViewById(R.id.Counter_tv);

        if(savedInstanceState != null){
            rotationCounter = savedInstanceState.getInt("rotationCount");
        }
        rotationCounter++;
        viewNumberRotation_tv.setText("Rotations: " + rotationCounter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("rotationCount",rotationCounter);
    }
}