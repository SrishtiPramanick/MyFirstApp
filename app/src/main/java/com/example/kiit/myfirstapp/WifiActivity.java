package com.example.kiit.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class WifiActivity extends AppCompatActivity implements View.OnClickListener {
Switch sw;
ListView lv;
Button b1,b2,b3;
TextView tv;
ArrayList<String> al;
WifiManager wm;
ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        sw=findViewById(R.id.switch1);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        lv=findViewById(R.id.listView);
        tv=findViewById(R.id.textView);
        b1.setOnClickListener(this);
        al=new ArrayList();
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        sw.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        wm= (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if(view==sw){
              if(sw.isChecked()){
                  wm.setWifiEnabled(true);
              }
              else {
                  wm.setWifiEnabled(false);
              }
        }
        else if(view==b1){
            if(wm.isWifiEnabled()){
                List<WifiConfiguration> list=wm.getConfiguredNetworks();
                for(WifiConfiguration x:list){
                    String name=x.SSID;
                    al.add(name);
                }
                adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,al);
                lv.setAdapter(adapter);
            }
            else{
                Toast.makeText(this,"Please switch on WiFi",Toast.LENGTH_LONG).show();
            }
        }
        else if(view==b2){
            WifiInfo info=wm.getConnectionInfo();
            String name=info.getSSID();
            int x=info.getRssi();
            tv.setText(name+" "+x);

        }
        else if(view==b3){
            Intent i=new Intent(Settings.ACTION_WIFI_SETTINGS);
            startActivity(i);

        }
    }
}
