package com.example.recyclerviewapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{

    Context context;
    String s1[], s2[];
    int ir1[];

    public MyAdapter(Context context, String s1[], String s2[], int ir1[]){
        this.context = context;
        this.s1 = s1;
        this.s2 = s2;
        this.ir1 = ir1;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup vGroup, int i) {
        LayoutInflater myInflater = LayoutInflater.from(context);
        View myView = myInflater.inflate(R.layout.my_row_layout, vGroup, false );
        return new MyHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.txt1.setText(s1[i]);
        myHolder.txt2.setText(s2[i]);
        myHolder.img1.setImageResource(ir1[i]);
    }

    @Override
    public int getItemCount() {
        return s1.length;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView txt1, txt2;
        ImageView img1;

        public MyHolder(View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.txt1);
            txt2 = itemView.findViewById(R.id.txt2);
            img1 = itemView.findViewById(R.id.img1);
        }
    }
}
