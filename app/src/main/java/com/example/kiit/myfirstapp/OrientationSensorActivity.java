package com.example.kiit.myfirstapp;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class OrientationSensorActivity extends AppCompatActivity implements SensorEventListener{
TextView tv;
SeekBar sb1,sb2,sb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation_sensor);
        tv=findViewById(R.id.textView);
        SensorManager sm= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,s,0);

        sb1=findViewById(R.id.seekBar7);
        sb2=findViewById(R.id.seekBar8);
        sb3=findViewById(R.id.seekBar9);
        sb1.setMax(256);
        sb2.setMax(256);
        sb3.setMax(256);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x=sensorEvent.values[0];
        float y=sensorEvent.values[1];
        float z=sensorEvent.values[2];
        int x1=(int) ((x+10)*12.8);
        int y1=(int) ((y+10)*12.8);
        int z1=(int) ((z+10)*12.8);
        sb1.setProgress(x1);
        sb2.setProgress(y1);
        sb3.setProgress(z1);
        int c=Color.rgb(x1,y1,z1);
        tv.setBackgroundColor(c);



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void vibrate(View view) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(55000);


    }
}
