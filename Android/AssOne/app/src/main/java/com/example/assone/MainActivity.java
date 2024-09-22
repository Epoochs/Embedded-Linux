package com.example.assone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText MobileNumber_et, Message_et;
    private Button Next_bt, Close_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileNumber_et = (EditText) findViewById(R.id.MobileNumber_et);
        Message_et = (EditText) findViewById(R.id.Message_et);
        Next_bt = (Button) findViewById(R.id.Next_bt);
        Close_bt = (Button) findViewById(R.id.Close_bt);

        Next_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobileNumber = MobileNumber_et.getText().toString();
                String message = Message_et.getText().toString();

                // getting to the second Activity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("MobileNumber", mobileNumber);
                intent.putExtra("Message", message);
                startActivity(intent);
            }
        });

        Close_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
