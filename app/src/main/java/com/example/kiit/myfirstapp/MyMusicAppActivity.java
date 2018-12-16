package com.example.kiit.myfirstapp;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class MyMusicAppActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, MediaPlayer.OnCompletionListener {
ListView lv;
ArrayList al,al2;
MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_music_app);
        mp=new MediaPlayer();
        lv=findViewById(R.id.listView);
        al=new ArrayList();
        al2=new ArrayList();
        Uri uri= MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        ContentResolver cr=getContentResolver();
        Cursor c=cr.query(uri,null,MediaStore.Audio.Media.IS_MUSIC+"!=0",null,MediaStore.Audio.Media.TITLE+" ASC");
        int n=c.getColumnIndex(MediaStore.Audio.Media.DATA);
        int m=c.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME);
        while(c.moveToNext()){
            String s1=c.getString(n);
            String s2=c.getString(m);
            al2.add(s2);
            al.add(s1);
        }
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,al2);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mp.reset();
        try {
            mp.setDataSource((String)al.get(i));
            mp.prepare();

            mp.start();
            mp.setOnCompletionListener(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mp.stop();
    }

    public void play(View view) {
        if(mp.isPlaying()){

        }
        else{
            mp.start();
        }
    }

    public void pause(View view) {
        if(mp.isPlaying()){
        mp.pause();}
    }

    public void stop(View view) {
        mp.stop();
    }
}
