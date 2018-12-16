package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Counter2Activity extends AppCompatActivity  {
TextView tv;
int i=0;
Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter2);
        tv = findViewById(R.id.textView7);
         b1=findViewById(R.id.button8);
         b2=findViewById(R.id.button9);
         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 i++;
                 tv.setText("Counter = "+i);
             }
         });
         b2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 i--;
                 tv.setText("Counter = "+i);

             }
         });

   /*
     public class Counter2Activity extends AppCompatActivity  implements View.OnClickListener
   b1.setOnClickListener(this);
         b2.setOnClickListener(this);

}

    @Override
    public void onClick(View view) {
        if(view==b1)
            i++;
        else if(view==b2)
            i--;
        tv.setText("Counter = "+i);



   */



    /*
     Increment i= new Increment();
     Decrement d = new Decrement();
     b1.setOnClickListener(i);
     b2.setOnClickListener(d);


    class Increment implements View.OnClickListener {
        @Override
        public void onClick(View view) { i++;
        tv.setText("Counter = "+i);
        }
    }

    private class Decrement implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            i--;
            tv.setText("Counter = "+i);
        }
    }*/
}}
