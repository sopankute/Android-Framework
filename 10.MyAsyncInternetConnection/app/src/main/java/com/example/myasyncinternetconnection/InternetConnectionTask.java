package com.example.myasyncinternetconnection;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.AsynchronousChannelGroup;

public class InternetConnectionTask extends AsyncTask<String, Void, String> {

    Context ctx;
    public InternetConnectionTask(Context ctx){
        this.ctx = ctx;
    }
    @Override
    protected String doInBackground(String... str) {
        String s1 = str[0];
        InputStream inst;

        try {
            URL myUrl = new URL(s1);
            HttpURLConnection myCon = (HttpURLConnection)myUrl.openConnection();
            myCon.setReadTimeout(10000);
            myCon.setConnectTimeout(20000);
            myCon.setRequestMethod("GET");
            myCon.connect();

            inst = myCon.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inst));
            StringBuilder sb = new StringBuilder();
            String line = "";
            while((line = br.readLine()) != null){
                sb.append(line+" \n");
            }

            br.close();
            inst.close();

            return sb.toString();

        } catch(MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(String s){
        MainActivity.txtView.setText(s);
    }
}
