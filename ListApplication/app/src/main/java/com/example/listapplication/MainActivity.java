package com.example.listapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Spinner spinner;
    AutoCompleteTextView actView;

    ArrayList<String> arrNames = new ArrayList<>();
    ArrayList<String> arrIDs = new ArrayList<>();
    ArrayList<String> arrLang = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListView
        listView = findViewById(R.id.listView);

        arrNames.add("Pune");
        arrNames.add("Nagpur");
        arrNames.add("Mumbai");
        arrNames.add("Aurangabad");
        arrNames.add("Parbhani");
        arrNames.add("Nanded");
        arrNames.add("Amaravati");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0){
                    Toast.makeText(MainActivity.this,"Clicked first item",Toast.LENGTH_SHORT).show();
                }

            }
        });

        // Spinner
        spinner = findViewById(R.id.spinner);

        arrIDs.add("Aadhar Card");
        arrIDs.add("PAN Card");
        arrIDs.add("Voter Card");
        arrIDs.add("Driving License Card");
        arrIDs.add("Ration Card");
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,arrIDs);
        spinner.setAdapter(spinnerAdapter);

        // AutoCompleteTextView
        actView = findViewById(R.id.actView);
        arrLang.add("C");
        arrLang.add("C++");
        arrLang.add("Java");
        arrLang.add("PHP");
        arrLang.add("C#");
        arrLang.add("JavaScript");

        ArrayAdapter<String> actvAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrLang);
        actView.setAdapter(actvAdapter);
        actView.setThreshold(1);

    }
}








