package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {
int i;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        tv=findViewById(R.id.textView2);
    }

    public void clickheretoincrement(View view) {
        i++;
        tv.setText("Counter = "+i);
    }

    public void clickheretodecrement(View view) {
        i--;
        tv.setText("Counter = "+i);
    }
}
