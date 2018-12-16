package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MinutesSeconds2Activity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
SeekBar sk;
TextView tv1,tv2;
int j,t;int min,sec,k;
String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minutes_seconds2);
        tv1=findViewById(R.id.textView26);
        tv2=findViewById(R.id.textView27);
        sk=findViewById(R.id.seekBar2);
        Bundle b=getIntent().getExtras();
        s1=b.getString("m");
        s2=b.getString("s");
        tv2.setText(s1+":"+s2);
        int m=Integer.parseInt(s1);
        int s=Integer.parseInt(s2);
        t=((m*60)+s);
        sk.setMax(t);
        sk.setOnSeekBarChangeListener(this);
        class MyThread extends Thread{
            public void run(){
                for(j=0;j<=t;j++){
                    sk.setProgress(j);
                    k=j;
                    min=k/60;
                    sec=k-(min*60);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv1.setText(" "+min+":"+sec);
                        }
                    });

                    try {
                        Thread.sleep(t);
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
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
