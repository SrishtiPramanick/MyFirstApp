package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteActivity extends AppCompatActivity {
AutoCompleteTextView at;
String[] s={"Aanand","Abhishek","Alok","Basu","Banu"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);
        at=findViewById(R.id.autoCompleteTextView);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,s);
        at.setAdapter(adapter);
        at.setThreshold(1);

    }
}
