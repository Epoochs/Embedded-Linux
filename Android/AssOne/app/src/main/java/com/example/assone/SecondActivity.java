package com.example.assone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SecondActivity extends AppCompatActivity {

    TextView MobileNumberValue_tv, MessageValue_tv;
    Button btnCloseSecond, btnSharedWrite, btnSharedRead, btnFileWrite, btnFileRead, btnSQWrite, btnSQRead;
    FileOutputStream fos;
    BufferedReader bf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        // Getting Components Ref
        MobileNumberValue_tv = findViewById(R.id.tvMobileNumberValue);
        MessageValue_tv = findViewById(R.id.tvMessageValue);
        btnCloseSecond = findViewById(R.id.CloseSecond_bt);

        // Shared Buttons
        btnSharedWrite = findViewById(R.id.btnShWr);
        btnSharedRead = findViewById(R.id.btnShR);

        // File Buttons
        btnFileWrite = findViewById(R.id.btnFileWr);
        btnFileRead = findViewById(R.id.btnFileR);

        //SQLate buttons
        btnSQWrite = findViewById(R.id.btnSQWr);
        btnSQRead = findViewById(R.id.btnSQR);

        // Get the intent values
        Intent intent = getIntent();
        String mobileNumber = intent.getStringExtra("MobileNumber");
        String message = intent.getStringExtra("Message");

        // Set the values in TextViews
        MobileNumberValue_tv.setText(mobileNumber);
        MessageValue_tv.setText(message);

        // Write data to sharedPreferences
        SharedPreferences sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);



        btnCloseSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSharedWrite.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("Mobile", mobileNumber);
            editor.putString("Msg", message);
            editor.apply(); // Why asked me to change to apply
            MobileNumberValue_tv.setText("");
            MessageValue_tv.setText("");
        });

        btnSharedRead.setOnClickListener(v -> {
            MobileNumberValue_tv.setText(sharedPref.getString("Mobile",""));
            MessageValue_tv.setText(sharedPref.getString("Msg",""));
        });

        btnFileWrite.setOnClickListener( v -> {
            try {
                fos = openFileOutput("data.txt",Context.MODE_PRIVATE);

                fos.write(mobileNumber.getBytes());
                fos.write(",".getBytes());
                fos.write(message.getBytes());
                fos.write("\n".getBytes());

                MobileNumberValue_tv.setText("");
                MessageValue_tv.setText("");

                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        btnFileRead.setOnClickListener(v -> {
            try {
                /*
                * FileInputStream : is used to read files in terms of bytes
                * */
                FileInputStream fis = openFileInput("data.txt");

                /*
                * InputStreamReader : is used to translate the bytes into characters
                * BufferedReader : is going to create an internal buffer to save the characters in it
                * */
                bf = new BufferedReader(new InputStreamReader(fis));

                /* ReadLine() return  a string that is written in the line */
                String str = bf.readLine();
                /*
                * str : string to be tokenized
                * delim : the char or set of char that is going to seperate the string into tokens
                * returnDelims : specifiy whether or not to include the delim as a token
                * */
                StringTokenizer s = new StringTokenizer(str, ",",false);

                /*
                * nextToken() : is going to return the tokens of the string as long as there are more tokens
                * */
                MobileNumberValue_tv.setText(s.nextToken());
                MessageValue_tv.setText(s.nextToken());
                bf.close();
                fis.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
