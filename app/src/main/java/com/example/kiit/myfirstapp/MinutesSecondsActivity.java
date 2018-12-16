package com.example.kiit.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MinutesSecondsActivity extends AppCompatActivity implements View.OnClickListener {
EditText et1,et2;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minutes_seconds);
        et1=findViewById(R.id.editText1);
        et2=findViewById(R.id.editText2);
        b=findViewById(R.id.button);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String s1=et1.getText().toString();
        String s2=et2.getText().toString();
        Intent intent=new Intent(this,MinutesSeconds2Activity.class);
        intent.putExtra("m",s1);
        intent.putExtra("s",s2);
        startActivity(intent);
    }
}
