package com.example.bmiapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editWeight, editHtFeet, editHtInch;
        Button btnCalculate;
        TextView txtResult;
        editWeight = findViewById(R.id.editWt);
        editHtFeet = findViewById(R.id.editHtFt);
        editHtInch = findViewById(R.id.editHtIn);
        btnCalculate = findViewById(R.id.BtnCalculate);
        txtResult = findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               int wt = Integer.parseInt(editWeight.getText().toString());
               int feet = Integer.parseInt(editHtFeet.getText().toString());
               int inch = Integer.parseInt(editHtInch.getText().toString());

               int totalInch = feet * 12 + inch;
               double totalCm = totalInch * 2.53;
               double totalMeter = totalCm / 100;
               double bmi = wt/(totalMeter * totalMeter);

               if(bmi>25){
                   txtResult.setText("You're OverWeight");
               }else if(bmi<18){
                   txtResult.setText("You're UnderWeight");
               }else{
                   txtResult.setText("You're Healthy");
               }
            }
        });


    }
}