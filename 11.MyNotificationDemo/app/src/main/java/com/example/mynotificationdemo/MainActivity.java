package com.example.mynotificationdemo;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomething(View view) {
        NotificationManagerCompat myManager = NotificationManagerCompat.from(this);

        NotificationCompat.Builder myNotification = new NotificationCompat.Builder(this);
        myNotification.setContentTitle("1 new Message");
        myNotification.setContentText("Hi, how are you?");
        myNotification.setSmallIcon(android.R.drawable.ic_btn_speak_now);

        Intent i1 = new Intent(this, MainActivity.class);
        PendingIntent pd = PendingIntent.getActivity(this,1,i1,0);

        myNotification.setContentIntent(pd);
        myNotification.setAutoCancel(true);

        myManager.notify(1,myNotification.build());
    }
}