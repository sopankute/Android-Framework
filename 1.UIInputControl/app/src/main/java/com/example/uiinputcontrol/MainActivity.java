package com.example.uiinputcontrol;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3, et4;
    RadioButton Rd1, Rd2, Rd3;
    Button btn1, btn2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        Rd1 = findViewById(R.id.Rd1);
        Rd2 = findViewById(R.id.Rd2);
        Rd3 = findViewById(R.id.Rd3);
        btn2 = findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(btn2.isClickable())
                    Toast.makeText(MainActivity.this, "Data Is Submitted Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onAlert(View view){
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setTitle("Exit");
        myAlert.setMessage("Are you sure?");
        myAlert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        myAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        myAlert.setCancelable(false);
        myAlert.show();
    }

    public void openProgress(View view){
        ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Downloading");
        pd.setMessage("Please wait...");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
       /* pd.setButton(ProgressDialog.BUTTON_NEGATIVE, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });*/
        Toast.makeText(MainActivity.this, "Progress Tested Successfully", Toast.LENGTH_SHORT).show();
    }
}