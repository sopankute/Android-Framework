package com.example.backgroundthreadapp;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.backgroundthreadapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ActivityMainBinding viewbind;
    Handler mainHandler = new Handler();
    private volatile boolean stopThread = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewbind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewbind.getRoot());
    }
    public void onStart(View view){
        stopThread = false;

    /*    ExampleThread thread = new ExampleThread(10);
        thread.start();     */

        ExampleRunnable runnable = new ExampleRunnable(10);
        Thread thread = new Thread(runnable);
        thread.start();

    /*    new Thread(new Runnable() {
            @Override
            public void run() {
                viewbind.btn1.setText("start");
            }
        }).start();*/
    }
    public void onStop(View view){
        stopThread = true;
    }

    class ExampleThread extends Thread{
        int seconds;
        public ExampleThread(int seconds){
            this.seconds = seconds;
        }
        @Override
        public void run() {
            for(int i=0; i<10; i++){
                Log.d(TAG, "Background Thread Started: "+i);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            Log.d(TAG, "Thread End !! ");
        }
    }

    class ExampleRunnable implements Runnable{
        int seconds;
        public ExampleRunnable(int seconds){
            this.seconds = seconds;
        }
        @Override
        public void run(){
            for(int i=0; i<10; i++){

                if(stopThread){
                    return;
                }

                if(i==5){
                    // this is main handler and tied to the main Thread
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            viewbind.btn1.setText("Good");
                        }
                    });

                /*    Handler threadHandler = new Handler(Looper.getMainLooper());
                    threadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            viewbind.btn1.setText("Better");
                        }
                    });*/

                /*    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            viewbind.btn1.setText("Best");
                        }
                    });*/
                }
                Log.d(TAG, "Background Thread Started: "+i);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            Log.d(TAG, "Thread End !! ");
        }
    }
}