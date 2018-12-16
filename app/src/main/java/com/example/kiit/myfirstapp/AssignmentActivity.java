package com.example.kiit.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class AssignmentActivity extends AppCompatActivity {
ProgressBar pb;
int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        pb=findViewById(R.id.progressBar2);
        pb.setMax(100);
        class DownLoadThread extends Thread{
            public void run(){
                for( i=0;i<=100;i++){
                    pb.setProgress(i);
                    try {
                        Thread.sleep(5000);
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

        Intent intent=new Intent(this,ScreenMenuActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
    }
}

