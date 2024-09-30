package com.example.mysharedpreferenceapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    EditText name, age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
    }
    @Override
    protected void onResume() {
        super.onResume();
        @SuppressLint("WrongConstant")
        SharedPreferences sp1 = getSharedPreferences("MyShared", MODE_APPEND);
        String str = sp1.getString("user","");
        int i1 = sp1.getInt("age",0);

        name.setText(str);
        age.setText(String.valueOf(i1));
    }
    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences sp = getSharedPreferences("MyShared",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sp.edit();
        myEdit.putString("user",name.getText().toString());
        myEdit.putInt("age",Integer.parseInt(age.getText().toString()));
        myEdit.commit();
    }
}