package com.example.kiit.myfirstapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Set;

public class BluetoothActivity extends AppCompatActivity implements View.OnClickListener {
Switch sw;
ListView lv;
ArrayList al;
BluetoothAdapter ba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        lv=findViewById(R.id.listView2);
        al=new ArrayList();
        sw=findViewById(R.id.switch2);
        ba=BluetoothAdapter.getDefaultAdapter();
        if(ba!=null){
            sw.setOnClickListener(this);
        }

    }

    public void getconnecteddevices(View view) {
        if(ba!=null){
        Set<BluetoothDevice> bluetoothDeviceSet=ba.getBondedDevices();
        for(BluetoothDevice device: bluetoothDeviceSet){
            String name=device.getName();
            al.add(name);
        }
            ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,al);
            lv.setAdapter(adapter);
        }
    }

    public void gotosettings(View view) {
        if(ba!=null){
            Intent i=new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
            startActivity(i);
        }

    }

    @Override
    public void onClick(View view) {
        if(sw.isChecked()){
            ba.enable();
        }
        else{
          ba.disable();
        }
    }
}
