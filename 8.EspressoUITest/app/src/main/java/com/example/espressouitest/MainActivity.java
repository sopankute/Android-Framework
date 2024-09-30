package com.example.espressouitest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.txtedt);
    }
    public void doSomething(View view){
        Intent intent = new Intent(this,Second.class);
        intent.putExtra("key1", e1.getText().toString());
        startActivity(intent);
    }
}