package com.example.viewbindingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.viewbindingapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainxml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainxml = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainxml.getRoot());

        mainxml.t1.setText("I am Changed Now");

        mainxml.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),newPage.class));
            }
        });
    }
}