package com.example.kiit.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyServiceActivity extends AppCompatActivity implements View.OnClickListener {
Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==b1){

            Intent intent=new Intent(this,MyService.class);
            startService(intent);

        }
        else if(view==b2){

            Intent intent=new Intent(this,MyService.class);
            stopService(intent);
        }
    }
}
