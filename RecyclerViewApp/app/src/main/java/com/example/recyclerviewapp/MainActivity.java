package com.example.recyclerviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ContactModel> arrContacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerContacts);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       /* ContactModel contact1 = new ContactModel(R.drawable.asdfghj,"Vinay","7863728937");
        arrContacts.add(contact1);*/

        arrContacts.add(new ContactModel(R.drawable.asdfghj,"Vinay","7863728937"));
        arrContacts.add(new ContactModel(R.drawable.coffee_shop_logo,"Rahul","7863728937"));
        arrContacts.add(new ContactModel(R.drawable.face01,"Rushabh","7863728937"));
        arrContacts.add(new ContactModel(R.drawable.german_shepherd,"Surya","7863728937"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_contacts_24,"Virat","7863728937"));
        arrContacts.add(new ContactModel(R.drawable.girls_with_toys,"Rohit","7863728937"));
        arrContacts.add(new ContactModel(R.drawable.gravure_lovely,"Vikas","7863728937"));
        arrContacts.add(new ContactModel(R.drawable.asdfghj,"Audumbar","7863728937"));
        arrContacts.add(new ContactModel(R.drawable.ninja_fighter_with,"Ganesh","7863728937"));
        arrContacts.add(new ContactModel(R.drawable.asdfghj,"Pankaj","7863728937"));
        arrContacts.add(new ContactModel(R.drawable.golden_fish,"Sopan","7863728937"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);
    }
}