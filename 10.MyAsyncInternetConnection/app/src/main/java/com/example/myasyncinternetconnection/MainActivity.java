package com.example.myasyncinternetconnection;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    InternetConnectionTask ict;
    DownloadImageTask downloadImage;
    static TextView txtView;
    static ImageView img;

    ConnectivityManager myConMngr;
    NetworkInfo myInfo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txtView);
    }
    public void doSomething(View view){
        ict = new InternetConnectionTask(this);
        ict.execute("http://www.google.com");
    }
    public void downloadImage(View view){
        if(myInfo != null && myInfo.isConnected()){
            downloadImage = new DownloadImageTask();
            downloadImage.execute("https://wallpaper-house.com/data/out/7/wallpaper2you_141809.jpg");
        }
        else{
            Toast.makeText(this, "Internet is not Connected", Toast.LENGTH_SHORT).show();
        }
    }
}