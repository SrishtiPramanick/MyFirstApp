package com.example.kiit.myfirstapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MusicPlayerActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener, View.OnClickListener {
MediaPlayer mp;
int t,m,n;
ArrayList<Integer> al;
TextView tv2;
Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        al=new ArrayList<Integer>();
         b1 = findViewById(R.id.button30);
        b2 = findViewById(R.id.button32);
        b3=findViewById(R.id.button34);
        b4=findViewById(R.id.button35);
        al.add(R.raw.morethanthis);
        al.add(R.raw.demons);
        al.add(R.raw.littlethings);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        mp = MediaPlayer.create(this,R.raw.littlethings);
    }







    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mp.stop();
    }

    public void previous(View view) {




    }

    public void next(View view) {
    }


    @Override
    public void onClick(View view) {
        if (view == b1) {
            Toast.makeText(this,"B1",Toast.LENGTH_LONG).show();
            if (mp != null)
            {
                Log.e("XXXXXXX","1st");
                if(mp.isPlaying())
                {Log.e("XXXXXXX","2nd");
                    mp.pause();
                }
                else {
                    Log.e("XXXXXXX","3rd");
                    mp.start();
                }
            }
            else {Log.e("XXXXXXX","4th");
                mp = MediaPlayer.create(this,R.raw.littlethings);
                mp.start();
            }



         }
        else if(view == b2 )
        {
            if(mp!=null)
            {
                mp.stop();
                mp = null;
            }
        }
        else if (view==b3){


        }
        else if(view==b4){

        }

    }
}

