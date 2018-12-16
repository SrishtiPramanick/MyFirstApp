package com.example.kiit.myfirstapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class DateAndTimeActivity extends AppCompatActivity implements View.OnClickListener {
EditText et1,et2;
TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time);
        et1=findViewById(R.id.editText1);
        et2=findViewById(R.id.editText2);
        tv1=findViewById(R.id.textView1);
        tv2=findViewById(R.id.textView2);
        et1.setOnClickListener(this);
        et2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==et1){
            Calendar c=Calendar.getInstance();
            int y=c.get(Calendar.YEAR);
            int m=c.get(Calendar.MONTH);
            int d=c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dp=new DatePickerDialog(this,new MyDate(),y,m,d);
            dp.show();
        }
        else if (view==et2){
            Date d=new Date();
            int i=d.getHours();
            int j=d.getMinutes();
            TimePickerDialog tp=new TimePickerDialog(this,new MyTime(),i,j,true);
            tp.show();
        }

    }

    class MyDate implements DatePickerDialog.OnDateSetListener {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            et1.setText(i2+":"+(i1+1)+":"+i);
            tv1.setText(i2+":"+(i1+1)+":"+i);
        }
    }

    private class MyTime implements TimePickerDialog.OnTimeSetListener {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            et2.setText(i+":"+i1);
            tv2.setText(i+":"+i1);
        }
    }
}
