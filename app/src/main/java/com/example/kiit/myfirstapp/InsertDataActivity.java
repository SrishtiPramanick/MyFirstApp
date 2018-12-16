package com.example.kiit.myfirstapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertDataActivity extends AppCompatActivity implements View.OnClickListener {
EditText et1,et2,et3;
Button b;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        et1=findViewById(R.id.editText1);
        et2=findViewById(R.id.editText2);
        et3=findViewById(R.id.editText3);
        b=findViewById(R.id.button);
        db=openOrCreateDatabase("rcpl_db",MODE_PRIVATE,null);
        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String s1=et1.getText().toString();
        String s2=et2.getText().toString();
        String s3=et3.getText().toString();
       try {
           String query = "insert into Student values(" + s1 + ",'" + s2 + "','" + s3 + "')";
           db.execSQL(query);
           Toast.makeText(this,"Data inserted",Toast.LENGTH_LONG).show();
       }
       catch (Exception e){
           Toast.makeText(this,"Error: "+e,Toast.LENGTH_LONG).show();
       }
        Intent i=new Intent(this,DatabaseActivity.class);
       startActivity(i);
    }
}
