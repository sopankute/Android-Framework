package com.example.handlerlooperthreadapp;

import static com.example.handlerlooperthreadapp.ExampleHandler.TASK_1;
import static com.example.handlerlooperthreadapp.ExampleHandler.TASK_2;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.handlerlooperthreadapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding viewBind;
    private static final String TAG = "MainActivity";
    private ExampleLooperThread looperThread = new ExampleLooperThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBind.getRoot());
    }

    public void onStart(View view){
        looperThread.start();
    }

    public void onTask1(View view){

        Message msg = Message.obtain();
        msg.what = TASK_1;
        looperThread.handler.sendMessage(msg);

        /*Handler threadhandler = new Handler(looperThread.looper);
        threadhandler.post(new Runnable() {
    //  looperThread.handler.post(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10; i++){
                    Log.d(TAG, "Task_1 running: "+i);
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });*/
    }
    public void onTask2(View view){
        Message msg = Message.obtain();
        msg.what = TASK_2;
        looperThread.handler.sendMessage(msg);
    }

    public void onStop(View view){
        looperThread.looper.quit();
    }
}