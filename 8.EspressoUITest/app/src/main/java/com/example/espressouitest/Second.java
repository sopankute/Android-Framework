package com.example.espressouitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle b1 = getIntent().getExtras();
        String s1 = b1.getString("key1");

        txt1 = findViewById(R.id.txt1);
        txt1.setText(s1);

    }
}