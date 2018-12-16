package com.example.kiit.myfirstapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class ProximitySensorActivity extends AppCompatActivity implements SensorEventListener{
ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);
        iv=findViewById(R.id.imageView3);
        SensorManager sm= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor s=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this,s,0);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float data=sensorEvent.values[0];
        Toast.makeText(this,""+data,Toast.LENGTH_SHORT).show();
        if(data==0.0){
            iv.setImageResource(R.drawable.dog);
        }
        else{
            iv.setImageResource(R.drawable.cat);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
