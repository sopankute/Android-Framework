package com.example.intentpassingapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNext;
        btnNext = findViewById(R.id.btnNext);

        Intent iNext;
        iNext = new Intent(MainActivity.this,SecondActivity.class);

        iNext.putExtra("title","Home");
        iNext.putExtra("StudentName","Sopan");
        iNext.putExtra("RollNo","13");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(iNext);
            }
        });
    }
}