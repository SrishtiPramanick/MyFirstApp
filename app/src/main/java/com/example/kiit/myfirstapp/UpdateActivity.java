package com.example.kiit.myfirstapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
Button b1;
EditText et1,et2;
SQLiteDatabase db;
String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        //Bundle b=getIntent().getExtras();
        //s1=b.getString("id");
        //s2=b.getString("mob");
        b1=findViewById(R.id.button);
        et1=findViewById(R.id.editText1);
        et2=findViewById(R.id.editText2);

        //et1.setText(s1);
        //et2.setText(s2);
        b1.setOnClickListener(this);
        db=openOrCreateDatabase("rcpl_db",MODE_PRIVATE,null);
    }

    @Override
    public void onClick(View view) {
        int id=Integer.parseInt(et1.getText().toString());
        String s=et2.getText().toString();
        try {
            String query = "update Student set Mobile='" + s + "'where id =" + id;
            db.execSQL(query);
            Toast.makeText(this,"Data Updated",Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(this,"Error: "+e,Toast.LENGTH_LONG).show();
        }
        Intent i=new Intent(this,DatabaseActivity.class);
        startActivity(i);
    }
}
