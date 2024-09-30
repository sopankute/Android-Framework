package com.example.viewbindingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.viewbindingapp.databinding.ActivityNewPageBinding;

public class newPage extends AppCompatActivity {

        ActivityNewPageBinding newxml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        newxml = ActivityNewPageBinding.inflate(getLayoutInflater());
        setContentView(newxml.getRoot());

        newxml.t1.setText("I am also changed...");
    }
}