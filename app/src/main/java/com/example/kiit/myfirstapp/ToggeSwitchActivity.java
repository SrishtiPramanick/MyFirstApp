package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ToggeSwitchActivity extends AppCompatActivity implements View.OnClickListener {
TextView tv1,tv2;
Switch sw;
ToggleButton tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_togge_switch);
        tv1=findViewById(R.id.textView23);
        tv2=findViewById(R.id.textView24);
        sw=findViewById(R.id.switch1);
        tb=findViewById(R.id.toggleButton);
        sw.setOnClickListener(this);
        tb.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==sw){
             if(sw.isChecked()){
                 tv1.setText("WiFi is ON");
             }
             else{
                 tv1.setText("WiFi is OFF");
             }
        }
        else if(view==tb){
            if(tb.isChecked()){
                tv2.setText("Bluetooth is ON");
            }
            else{
                tv2.setText("Bluetooth is OFF");
            }
        }
    }
}
