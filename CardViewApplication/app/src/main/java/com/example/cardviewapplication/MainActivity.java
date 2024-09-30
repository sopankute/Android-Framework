package com.example.cardviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

public class MainActivity extends AppCompatActivity {
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardView = findViewById(R.id.card);

        /*cardView.setCardElevation(15.0f);
        cardView.setRadius(17.0f);
        cardView.setUseCompatPadding(true);*/
    }
}