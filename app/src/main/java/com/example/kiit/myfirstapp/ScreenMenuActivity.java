package com.example.kiit.myfirstapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ScreenMenuActivity extends ListActivity {
String[] functions={"AlertDialogActivity","AutoCompleteActivity","CalculatorActivity","CheckBoxActivity","CounterActivity","CalcActivity","DateAndTimeActivity","ImageResourceActivity",
        "FactorialActivity","IntentDemoActivity","GreetingActivity","MainActivity","MenuActivity","MinutesSecondsActivity","NameActivity","ProgressBarActivity","RadioActivity","LoginActivity",
        "RegisterActivity","SeekBarActivity","SpinnerActivity","ToggleSwitchActivity","Exit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    ArrayAdapter adapter=
            new ArrayAdapter(this,android.R.layout.simple_list_item_1,functions);

    setListAdapter(adapter);
}

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if(position==0) {
            Intent i = new Intent(this, AlertDialogActivity.class);
            startActivity(i);
        }
        else if(position==1) {
            Intent i = new Intent(this, AutoCompleteActivity.class);
            startActivity(i);
        }
         else if(position==2) {
            Intent i = new Intent(this, CalculatorActivity.class);
            startActivity(i);
        }
        else if(position==3) {
            Intent i = new Intent(this, CheckBoxActivity.class);
            startActivity(i);
        }
        else if(position==4) {
            Intent i = new Intent(this, CounterActivity.class);
            startActivity(i);
        }
        else if(position==5) {
            Intent i = new Intent(this, CalcActivity.class);
            startActivity(i);
        }
        else if(position==6) {
            Intent i = new Intent(this, DateAndTimeActivity.class);
            startActivity(i);
        }
        else if(position==7) {
            Intent i = new Intent(this, ImageResourceActivity.class);
            startActivity(i);
        }
        else if(position==8) {
            Intent i = new Intent(this, FactorialActivity.class);
            startActivity(i);
        }
        else if(position==9) {
            Intent i = new Intent(this, IntentDemoActivity.class);
            startActivity(i);
        }
        else if(position==10) {
            Intent i = new Intent(this,GreetingActivity.class);
            startActivity(i);
        }
        else if(position==11) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else if(position==12) {
            Intent i = new Intent(this, MenuActivity.class);
            startActivity(i);
        }
        else if(position==13) {
            Intent i = new Intent(this, MinutesSecondsActivity.class);
            startActivity(i);
        }
        else if(position==14) {
            Intent i = new Intent(this, NameActivity.class);
            startActivity(i);
        }
        else if(position==15) {
            Intent i = new Intent(this, ProgressBarActivity.class);
            startActivity(i);
        }
        else if(position==16) {
            Intent i = new Intent(this, RadioActivity.class);
            startActivity(i);
        }
        else if(position==17) {
            Intent i = new Intent(this,LoginActivity.class);
            startActivity(i);
        }

        else if(position==18) {
            Intent i = new Intent(this, RegisterActivity.class);
            startActivity(i);
        }
        else if(position==19) {
            Intent i = new Intent(this, SeekBarActivity.class);
            startActivity(i);
        }
        else if(position==20) {
            Intent i = new Intent(this, SpinnerActivity.class);
            startActivity(i);
        }
        else if(position==21) {
            Intent i = new Intent(this, ToggeSwitchActivity.class);
            startActivity(i);
        }
         else if(position==22) {
            finish();
        }

    }
}
