package com.example.aidlclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.aidlserver.IAidlColorInterface;

public class MainActivity extends AppCompatActivity {

    IAidlColorInterface iAidlColorInterface;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent("AIDLColorService");
        intent.setPackage("com.example.aidlserver");

        bindService(intent, mConnection, BIND_AUTO_CREATE);
        // that will help to connect AIDLColorService(AIDLServer)

        Log.d(TAG,"bindService called");

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int color = iAidlColorInterface.getColor();
                    view.setBackgroundColor(color);
                }catch(RemoteException e){ }
            }
        });
    }

    private ServiceConnection mConnection =new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            /*This is called when the connection with the service has been
            established, giving us the service object we can use to
            interact with the service.*/
            iAidlColorInterface = IAidlColorInterface.Stub.asInterface(iBinder);
            Log.d(TAG,"Remote config Service Connected !");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            // Called when the connection with the service disconnects unexpectedly
            Log.e(TAG, "Service has unexpectedly disconnected");
            iAidlColorInterface = null;
        }
    };


}