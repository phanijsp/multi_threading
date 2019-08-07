package com.example.multi_threading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Aditya,Jagatha,Phani,Jsp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Aditya = (TextView) findViewById(R.id.textViewAditya);
        Jagatha = (TextView) findViewById(R.id.textViewJagatha);
        Phani = (TextView) findViewById(R.id.textViewPhani);
        Jsp = (TextView) findViewById(R.id.textViewJsp);
        String[] names = {"Aditya","Jagatha","Phani","Jsp"};
        TextView[] textViews = {Aditya,Jagatha,Phani,Jsp};
        mthread[] mthreads=new mthread[names.length];
        for(int i =0 ; i<names.length;i++){
            mthreads[i]= new mthread(names[i],textViews[i]);
            mthreads[i].run();
        }


    }
}
