package com.example.kiit.myfirstapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, AdapterView.OnItemSelectedListener {
EditText et1,et2,et3,et4;
TextView tv1,tv2,tv3;
Button b;
Spinner sp;
String s1,s2,s3,s4,s5,s6,s7;
String[] city={"Enter city","Kolkata","Lucknow","Bhubaneswar","Vizag"};
RadioGroup r;
CheckBox ch1,ch2,ch3,ch4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et1=findViewById(R.id.editText1);
        et2=findViewById(R.id.editText2);
        et3=findViewById(R.id.editText3);
        et4=findViewById(R.id.editText4);
        sp=findViewById(R.id.spinner);
        tv1=findViewById(R.id.textView1);
        tv2=findViewById(R.id.textView2);
        tv3=findViewById(R.id.textView3);
        ch1=findViewById(R.id.checkBox1);
        ch2=findViewById(R.id.checkBox2);
        ch3=findViewById(R.id.checkBox3);
        ch4=findViewById(R.id.checkBox4);
        b=findViewById(R.id.button);
        r=findViewById(R.id.radiogroup);
        r.setOnCheckedChangeListener(this);
        b.setOnClickListener(this);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,city);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);
        et4.setOnClickListener(this);


    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch(i){
            case R.id.radioButton1:s6="Male" ;
                break;
            case R.id.radioButton2:s6="Female" ;
                break;
        }
    }

    @Override
    public void onClick(View view) {
        if(view==b){
        ArrayList al=new ArrayList();
        if(ch1.isChecked()){
            al.add("Playing");
        }
        if(ch2.isChecked()){
            al.add("Reading");
        }
        if(ch3.isChecked()){
            al.add("Sleeping");
        }
        if(ch4.isChecked()){
            al.add("Eating");
        }
        s7=""+al;
        s1=et1.getText().toString();
        s2=et2.getText().toString();
        s3=et3.getText().toString();
            Intent intent=new Intent(this,Register2Activity.class);
            intent.putExtra("Name",s1);
            intent.putExtra("Email",s2);
            intent.putExtra("Mobile",s3);
            intent.putExtra("City",s4);
            intent.putExtra("DOB",s5);
            intent.putExtra("Gender",s6);
            intent.putExtra("Hobby",s7);
            startActivity(intent);


    }
    if(view==et4){
        Calendar c=Calendar.getInstance();
        int y=c.get(Calendar.YEAR);
        int m=c.get(Calendar.MONTH);
        int d=c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dp=new DatePickerDialog(this,new MyTodayDate(),y,m,d);
        dp.show();


    }}

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        s4=city[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private class MyTodayDate implements DatePickerDialog.OnDateSetListener {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            s5=""+i2+":"+(i1-1)+":"+i;
            et4.setText(""+i2+":"+(i1-1)+":"+i);
        }
    }
}
