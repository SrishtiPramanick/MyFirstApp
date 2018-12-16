package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Date;

public class GreetingActivity extends AppCompatActivity {
TextView tv;
EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        et1=findViewById(R.id.editText3);
        tv=findViewById(R.id.textView5);
    }

    public void greetings(View view) {
        String name=et1.getText().toString();
        Date d= new Date();
        int h=d.getHours();
        if(h>=5&&h<11)
        tv.setText("Good Morning "+ name.toUpperCase());
        else if(h>=11&&h<16)
            tv.setText("Good Afternoon "+ name.toUpperCase());
        else if(h>=16&&h<22)
            tv.setText("Good Evening "+ name.toUpperCase());
        else if(h>=22||h<5)
            tv.setText("Good night "+ name.toUpperCase());

    }
}
