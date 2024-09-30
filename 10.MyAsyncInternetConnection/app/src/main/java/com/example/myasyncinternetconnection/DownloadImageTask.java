package com.example.myasyncinternetconnection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    @Override
    protected Bitmap doInBackground(String... strings) {
        String s1 = strings[0];
        InputStream inst;

        try {
            URL myUrl = new URL(s1);
            HttpURLConnection myCon = (HttpURLConnection)myUrl.openConnection();
            myCon.setReadTimeout(10000);
            myCon.setConnectTimeout(20000);
            myCon.setRequestMethod("GET");
            myCon.connect();

            inst = myCon.getInputStream();
            Bitmap myMap = BitmapFactory.decodeStream(inst);

            return myMap;

        } catch(MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void onPostExecute(Bitmap bitmap){
        MainActivity.img.setImageBitmap(bitmap);
    }
}
