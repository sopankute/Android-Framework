package com.example.recyclerviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView r1;
    String s1[], s2[];
    int imgResource[] = {R.drawable.cat,R.drawable.spotty_dog,R.drawable.cow,
                        R.drawable.rygle_colour_cows_2,R.drawable.colorful_pattern_elephant,
                        R.drawable.monkey_2015082721};

    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = findViewById(R.id.myRecycler);
        s1 = getResources().getStringArray(R.array.pet_name);
        s2 = getResources().getStringArray(R.array.desc);

        adapter = new MyAdapter(this, s1, s2, imgResource);

        r1.setAdapter(adapter);
        r1.setLayoutManager(new LinearLayoutManager(this));
    }
}