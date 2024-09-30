package com.example.serviceapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ServiceClass_1 extends Service {

    final class ThreadClass implements Runnable{
        int serviceId;
        ThreadClass(int serviceId){
            this.serviceId = serviceId;
        }
        public void run(){
            synchronized (this){
                try {
                    wait(10000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                stopSelf(this.serviceId);
            }
        }
    }
    public void onCreate(){
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int started){
        Toast.makeText(ServiceClass_1.this,"Service Started",Toast.LENGTH_SHORT).show();
        Thread thread = new Thread(new ThreadClass(started));
        thread.start();
        return START_STICKY;
    }

    public void onDestroy(){
        Toast.makeText(ServiceClass_1.this,"Service Destroyed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
