package com.example.intentserviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends Service {

    public MyService(){
    
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
