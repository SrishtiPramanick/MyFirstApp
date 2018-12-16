package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
EditText et1,et2;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        et1=findViewById(R.id.editText);
        et2=findViewById(R.id.editText2);
        tv=findViewById(R.id.textView4);
    }

    public void clickheretoadd(View view) {
        String firstnumber = et1.getText().toString();
        String secondnumber =et2.getText().toString();
        double x=Double.parseDouble(firstnumber);
        double y=Double.parseDouble(secondnumber);
        double z=x+y;
        tv.setText("RESULT = "+z);

    }

    public void clickheretosubstract(View view) {
        String firstnumber = et1.getText().toString();
        String secondnumber =et2.getText().toString();
        double x=Double.parseDouble(firstnumber);
        double y=Double.parseDouble(secondnumber);
        double z=x-y;
        tv.setText("RESULT = "+z);

    }

    public void clickheretomultiply(View view) {
        String firstnumber = et1.getText().toString();
        String secondnumber =et2.getText().toString();
        double x=Double.parseDouble(firstnumber);
        double y=Double.parseDouble(secondnumber);
        double z=x*y;
        tv.setText("RESULT = "+z);
    }

    public void clickheretodivide(View view) {
        String firstnumber = et1.getText().toString();
        String secondnumber =et2.getText().toString();
        double x=Double.parseDouble(firstnumber);
        double y=Double.parseDouble(secondnumber);
        double z=x/y;
        tv.setText("RESULT = "+z);
    }
}
