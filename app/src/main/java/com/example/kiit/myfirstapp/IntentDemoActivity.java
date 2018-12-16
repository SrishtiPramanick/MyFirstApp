package com.example.kiit.myfirstapp;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class IntentDemoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
ListView lv;
String[] screen={"Call","SMS","Web","WebSearch","Contacts","GoogleMaps","Finish"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_demo);
        lv=findViewById(R.id.listView1);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,screen);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast t=Toast.makeText(this,"Clicked on "+screen[i],Toast.LENGTH_LONG);
        t.show();
        if(i==0){
            Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:8697335949"));
            startActivity(intent);
        }
        else if(i==1){
            Intent intent=new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:8697335949"));
            intent.putExtra("sms_body","I am in class");
            startActivity(intent);
        }
        else if(i==2){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.rcplindia.in"));
            startActivity(intent);
        }
        else if(i==3){
            Intent intent=new Intent(Intent.ACTION_WEB_SEARCH, Uri.parse("https://www.google.com"));
            intent.putExtra(SearchManager.QUERY,"KIIT");
            startActivity(intent);
        }
        else if(i==4){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
            startActivity(intent);
        }
        else if(i==5){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:26.1445,91.7362"));
            startActivity(intent);
        }
        else if(i==6){
           finish();
        }
}}
