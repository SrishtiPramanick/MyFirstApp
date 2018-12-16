package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class CheckBoxActivity extends AppCompatActivity implements View.OnClickListener {
TextView tv;
Button b;
CheckBox cb1,cb2,cb3,cb4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        tv=findViewById(R.id.textView21);
        b=findViewById(R.id.button16);
        cb1=findViewById(R.id.checkBox);
        cb2=findViewById(R.id.checkBox2);
        cb3=findViewById(R.id.checkBox1);
        cb4=findViewById(R.id.checkBox3);
        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        ArrayList al=new ArrayList();
        if(cb1.isChecked()){
            al.add("Playing");
        }
        if(cb2.isChecked()){
            al.add("Reading");
        }
        if(cb3.isChecked()){
            al.add("Sleeping");
        }
        if(cb4.isChecked()){
            al.add("Eating");
        }
        tv.setText("Your Hobbies are: "+al);
    }
}
