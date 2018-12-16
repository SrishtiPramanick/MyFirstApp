package com.example.kiit.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
EditText et1,et2;
Button b;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1=findViewById(R.id.editText10);
        et2=findViewById(R.id.editText11);
        b=findViewById(R.id.button15);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i=new Intent(this,LoginResultActivity.class);
        String name = et1.getText().toString();
        String password=et2.getText().toString();
        i.putExtra("Name",name);
        i.putExtra("Password",password);
        startActivity(i);

    }
}
