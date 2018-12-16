package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
SeekBar sk;
int j;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        sk=findViewById(R.id.seekBar);
        tv=findViewById(R.id.textView25);

        sk.setOnSeekBarChangeListener(this);
        class MyThread extends Thread{
            public void run(){
                for(j=0;j<=100;j++){
                    sk.setProgress(j);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }
        MyThread myThread=new MyThread();
        myThread.start();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        j=i;
        tv.setText("POSITION: "+j);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast t=Toast.makeText(this,"START",Toast.LENGTH_LONG);
        t.show();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast t=Toast.makeText(this,"STOP",Toast.LENGTH_LONG);
        t.show();

    }
}
