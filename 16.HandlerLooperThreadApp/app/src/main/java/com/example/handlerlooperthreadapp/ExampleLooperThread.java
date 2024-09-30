package com.example.handlerlooperthreadapp;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.nio.file.LinkOption;

public class ExampleLooperThread extends Thread{

    private static final String TAG = "ExampleLooperThread";
    public Handler handler;
    public Looper looper;

    @Override
    public void run(){
        Looper.prepare();

        looper = Looper.myLooper();

        handler = new ExampleHandler();
//        handler = new Handler();

        Looper.loop();

        Log.d(TAG, "End of Thread");
    }
}
