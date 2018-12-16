package com.example.kiit.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DealActivity extends AppCompatActivity implements View.OnClickListener {
EditText et1,et2;
Button b1;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal);
        et1=findViewById(R.id.editText8);
        //Bundle b=getIntent().getExtras();
        //String s=b.getString("a");
        et2=findViewById(R.id.editText9);
        b1=findViewById(R.id.button25);
        tv=findViewById(R.id.textView34);
        //tv.setText(s);
        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String q=et1.getText().toString();
        String r=et2.getText().toString();
        Intent intent=new Intent(this,DealConfirmActivity.class);
        intent.putExtra("q",q);
        intent.putExtra("r",r);
         //startActivity(intent);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle b=data.getExtras();
        String s=b.getString("a");
        tv.setText(s);
    }
}
