package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.jar.Attributes;

public class Register2Activity extends AppCompatActivity {
TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        tv1=findViewById(R.id.textView1);
        tv2=findViewById(R.id.textView2);
        tv3=findViewById(R.id.textView3);
        tv4=findViewById(R.id.textView4);
        tv5=findViewById(R.id.textView5);
        tv6=findViewById(R.id.textView6);
        tv7=findViewById(R.id.textView7);
        Bundle b=getIntent().getExtras();
        String s1,s2,s3,s4,s5,s6,s7;
        s1=b.getString("Name");
        s2=b.getString("Email");
        s3=b.getString("Mobile");
        s4=b.getString("City");
        s5=b.getString("DOB");
        s6=b.getString("Gender");
        s7=b.getString("Hobby");
        tv1.setText("Name: "+ s1);
        tv2.setText("Email: "+s2);
        tv3.setText("Mobile Number: "+s3);
        tv4.setText("City: "+s4);
        tv5.setText("Date Of Birth: "+s5);
        tv6.setText("Gender: "+s6);
        tv7.setText("Hobbies: "+s7);
    }
}
