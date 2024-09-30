package com.example.intentpassingapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class SecondActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent fromAct = getIntent();
        String title = fromAct.getStringExtra("title");
        String StudentName = fromAct.getStringExtra("StudentName");
        int RollNo = fromAct.getIntExtra("RollNo",0);

        TextView txtStudentInfo;
        txtStudentInfo = findViewById(R.id.txtStudentInfo);
        txtStudentInfo.setText("Roll No : "+RollNo+", Name : "+StudentName);
        getSupportActionBar().setTitle(title);
    }
}