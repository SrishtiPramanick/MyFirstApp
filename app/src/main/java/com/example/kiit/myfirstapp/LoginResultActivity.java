package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginResultActivity extends AppCompatActivity {
TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);
        tv1=findViewById(R.id.textView13);
        tv2=findViewById(R.id.textView14);
        Bundle b=getIntent().getExtras();
        String name=b.getString("Name");
        String password = b.getString("Password");
        tv1.setText("Name : "+name);
        tv2.setText("Password: "+password);

    }
}
