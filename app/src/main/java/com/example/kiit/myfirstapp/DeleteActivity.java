package com.example.kiit.myfirstapp;

import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {
EditText et;
Button b;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        et=findViewById(R.id.editText1);
        b=findViewById(R.id.button);
        db=openOrCreateDatabase("rcpl_db",MODE_PRIVATE,null);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final int id=Integer.parseInt(et.getText().toString());
        final Dialog d=new Dialog(this);
        d.setContentView(R.layout.deletemenu);

        Button b1,b2;
        b1=d.findViewById(R.id.button31);
        b2=d.findViewById(R.id.button33);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String query="delete from Student where id ="+id;
                    db.execSQL(query);
                    Toast.makeText(DeleteActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                    d.dismiss();   Intent i=new Intent(DeleteActivity.this,DatabaseActivity.class);
                    startActivity(i);

                }
                catch (Exception e){
                    Toast.makeText(DeleteActivity.this,"Error: "+e,Toast.LENGTH_LONG).show();
                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.dismiss();   Intent i=new Intent(DeleteActivity.this,DatabaseActivity.class);
                startActivity(i);
            }
        });
        d.show();


    }
}
