package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {
EditText et1,et2;
TextView tv;
Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        et1=findViewById(R.id.editText5);
        et2=findViewById(R.id.editText6);
        tv=findViewById(R.id.textView8);
        b1=findViewById(R.id.button11);
        b2=findViewById(R.id.button12);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String s=et1.getText().toString();
        String s2=et2.getText().toString();
        double x=Double.parseDouble(s);
        double y=Double.parseDouble(s2);
        double z=0;
        if(view==b1)
            z=x+y;
        else if(view==b2)
            z=x*y;
        tv.setText("RESULT = "+z);

    }
}
