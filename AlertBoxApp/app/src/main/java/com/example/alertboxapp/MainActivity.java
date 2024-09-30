package com.example.alertboxapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

        alertDialog.setTitle("Terms and Condition");
        alertDialog.setIcon(R.drawable.ic_baseline_info_24);
        alertDialog.setMessage("Have you read all terms and condition ?");

        alertDialog.setButton("Yes, I've Read", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Yes,You can Proceed", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.show();
    }
}