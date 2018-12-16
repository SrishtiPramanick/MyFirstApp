package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
TextView tv;
RadioGroup rg;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        tv=findViewById(R.id.textView2);
        rg=findViewById(R.id.radiogroup);
        b=findViewById(R.id.button14);
        rg.setOnCheckedChangeListener(this);
        b.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch(i){
            case R.id.radioButton1: tv.setText("You have selected: CSE");
                break;
            case R.id.radioButton2: tv.setText("You have selected: IT");
                break;
            case R.id.radioButton3: tv.setText("You have selected: ECE");
                break;
            case R.id.radioButton4: tv.setText("You have selected: ME");
                break;

        }
    }

    @Override
    public void onClick(View view) {
        rg.clearCheck();
        tv.setText("You have selected: None");

    }
}
