package com.example.databindingmvapp;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.databindingmvapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainxml = DataBindingUtil.setContentView(this,R.layout.activity_main);

    //    mainxml.t1.setText("I am changed now");

        mainxml.setPname("Kute Sopan");     // DataBinding (Primitive-type)

        CollegeForm obj = new CollegeForm("MIT college of Eng.","Pune");
        mainxml.setCollegeform(obj);

    }
}