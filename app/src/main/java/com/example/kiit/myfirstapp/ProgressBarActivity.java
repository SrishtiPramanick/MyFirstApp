package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class ProgressBarActivity extends AppCompatActivity {
ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        pb=findViewById(R.id.progressBar);
        pb.setMax(100);
        class DownLoadThread extends Thread{
            public void run(){
                for(int i=0;i<=100;i++){
                    pb.setProgress(i);
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        DownLoadThread thread=new DownLoadThread();
        thread.start();
    }
}
