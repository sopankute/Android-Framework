package com.example.handlerlooperthreadapp;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class ExampleHandler extends Handler {

    private static final String TAG = "ExampleHAndler";
    public static final int TASK_1 = 1;
    public static final int TASK_2 = 2;

    @Override
    public void handleMessage(Message msg){

        switch(msg.what){
            case TASK_1:
                Log.d(TAG, "TASK_1 is executed");
                break;

            case TASK_2:
                Log.d(TAG, "TASK_2 is executed");
                break;
        }
    }
}
