package com.example.multi_threading;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.Random;

public class mthread extends Thread{
    String name;
    TextView textView;
    Context context;
    mthread(String name, TextView textView){
        this.name = name;
        this.textView = textView;
    }

    @Override
    public void run() {
        final Handler handler = new Handler();
        final int[] count = {0};
        Runnable runnableCode = new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {
                int i;
                count[0]++;
                textView.setText("In\n"+name+"\ncount : \n"+ count[0]);
                if(getRandomNumberInts(0,10)==6){
                   i=3000;
                }else{
                    i=1000;
                }
                handler.postDelayed(this, i);
            }
        };
        handler.post(runnableCode);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int getRandomNumberInts(int min, int max){
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }
}
