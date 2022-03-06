package com.example.myapplication;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
   private boolean running;
   private  long pauseoffset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Chronometer chronometer=findViewById(R.id.chrono);
        Button button=findViewById(R.id.start);
        Button button1=findViewById(R.id.pause);
        Button button2=findViewById(R.id.restart);
       button.setOnClickListener(view -> {
         if(! running)
         {   chronometer.setBase(SystemClock.elapsedRealtime()-pauseoffset);
             chronometer.start();
             running =true;

         }
       });
       button1.setOnClickListener(view -> {
           if(running)
           {
           chronometer.stop();
           pauseoffset=SystemClock.elapsedRealtime()-chronometer.getBase();
           running=false;}
       });
       button2.setOnClickListener(view -> chronometer.setBase(SystemClock.elapsedRealtime()));
}}