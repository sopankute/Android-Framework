package com.example.menusapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.edit1);
        e2 = findViewById(R.id.edit2);

        registerForContextMenu(e1);
        registerForContextMenu(e2);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }
    @SuppressLint("NonConstantResourceId")
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){
            case R.id.mic :
                Toast.makeText(this, "Clicked on Mic", Toast.LENGTH_SHORT).show();
                break;
            case R.id.aboutus:
                Toast.makeText(this, "Clicked on About-Us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.status:
                Toast.makeText(this, "Clicked on Status", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(this, "Clicked on Setting", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,view,menuInfo);
        switch (view.getId()){
            case R.id.edit1 :
                        getMenuInflater().inflate(R.menu.edit1_menu, menu);
                    break;
            case R.id.edit2 :
                        getMenuInflater().inflate(R.menu.edit2_menu, menu);
                    break;
        }
    }
    public boolean onContextItemSelected(MenuItem item){
      switch (item.getItemId()){
          case R.id.one:
              Toast.makeText(this, "One Clicked", Toast.LENGTH_SHORT).show();
              break;
          case R.id.two:
              Toast.makeText(this, "Two Clicked", Toast.LENGTH_SHORT).show();
              break;
          case R.id.three:
              Toast.makeText(this, "Three Clicked", Toast.LENGTH_SHORT).show();
              break;
          case R.id.four:
              Toast.makeText(this, "Four Clicked", Toast.LENGTH_SHORT).show();
              break;
          case R.id.five:
              Toast.makeText(this, "Five Clicked", Toast.LENGTH_SHORT).show();
              break;
          case R.id.six:
              Toast.makeText(this, "Six Clicked", Toast.LENGTH_SHORT).show();
              break;
          case R.id.seven:
              Toast.makeText(this, "Seven Clicked", Toast.LENGTH_SHORT).show();
              break;
          case R.id.eight:
              Toast.makeText(this, "Eight Clicked", Toast.LENGTH_SHORT).show();
              break;
      }
      return true;
    }
}