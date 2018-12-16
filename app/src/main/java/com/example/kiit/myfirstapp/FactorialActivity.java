package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FactorialActivity extends AppCompatActivity {

TextView tv;
EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);
        tv=findViewById(R.id.textView9);
        et=findViewById(R.id.editText4);
        Button b= findViewById(R.id.button10);
        Factorial f=new Factorial();
        b.setOnClickListener(f);
    }

    private class Factorial implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String s=et.getText().toString();
            int i=Integer.parseInt(s);
            int x=1;
            while(i!=0){
            x=x*i;
            i--;
            }
            tv.setText("Result = "+x);
        }
    }
}
