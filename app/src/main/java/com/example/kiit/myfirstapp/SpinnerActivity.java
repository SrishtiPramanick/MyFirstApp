package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Spinner sp;
TextView tv;
String[] city={"Kolkata","Jaipur","Bhubaneswar","Lucknow"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        sp=findViewById(R.id.spinner);
        tv=findViewById(R.id.textView19);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,city);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        tv.setText("Selected: "+city[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
