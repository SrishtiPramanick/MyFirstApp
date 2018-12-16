package com.example.kiit.myfirstapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DatabaseActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        Bundle b= getIntent().getExtras();
        db=openOrCreateDatabase("rcpl_db",MODE_PRIVATE,null);


    }


    public void createtable(View view) {
        try {
            String query = "create table if not exists Student(id int primary key,Name varchar(30),Mobile varchar(20))";
            db.execSQL(query);
            Toast.makeText(this,"Table Created",Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(this,"Error:"+e,Toast.LENGTH_LONG).show();
        }
    }

    public void insertdata(View view) {
        Intent i=new Intent(this,InsertDataActivity.class);
        startActivity(i);
    }

    public void updatedata(View view) {
        Intent i=new Intent(this,UpdateActivity.class);
        startActivity(i);
    }

    public void deletedata(View view) {
        Intent i=new Intent(this,DeleteActivity.class);
        startActivity(i);
    }

    public void showdata(View view) {
        Intent i=new Intent(this,ShowDataActivity.class);
        startActivity(i);
    }
}
