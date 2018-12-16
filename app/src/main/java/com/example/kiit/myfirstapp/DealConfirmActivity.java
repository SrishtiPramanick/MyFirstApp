package com.example.kiit.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DealConfirmActivity extends AppCompatActivity implements View.OnClickListener {
TextView tv1,tv2;
Button b1,b2;
String d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_confirm);
        Bundle b=getIntent().getExtras();
        String s1=b.getString("q");
        String s2=b.getString("r");
        tv1=findViewById(R.id.textView1);
        tv2=findViewById(R.id.textView2);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        tv1.setText("Quantity: "+s1);
        tv2.setText("Rate: "+s2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i=new Intent();
        if(view==b1){
            Toast.makeText(this,"OK",Toast.LENGTH_LONG).show();
            d="Deal Confirmed";
            //Intent intent=new Intent(this,DealActivity.class);
            //intent.putExtra("a","Deal Confirmed");
            //startActivity(intent);
        }
        else if(view==b2){
            Toast.makeText(this,"Cancel",Toast.LENGTH_LONG).show();
            d="Deal Cancelled";
            //Intent intent=new Intent(this,DealActivity.class);
            //intent.putExtra("a","Deal Cancelled");
            //tartActivity(intent);
        }
        i.putExtra("a",d);
        setResult(5,i);
        finish();
    }
}
