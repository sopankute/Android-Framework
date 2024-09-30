package com.example.aidlserver;

import static android.content.ContentValues.TAG;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.Random;

public class AIDLColorService extends Service {

    private static final String TAG = "AIDLColorService";
    public AIDLColorService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final IAidlColorInterface.Stub binder = new IAidlColorInterface.Stub() {
        // binder(instance of Binder or Stub) - this instance is exposed to clients so they can interact with the service
        @Override
        public int getColor() throws RemoteException {
            Random rnd = new Random();
            int color = Color.argb(255,rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
            Log.d(TAG,"getColor : "+color);
            return color;
        }
    };
}