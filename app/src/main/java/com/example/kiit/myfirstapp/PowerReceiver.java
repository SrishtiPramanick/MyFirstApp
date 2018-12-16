package com.example.kiit.myfirstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.Toast;

public class PowerReceiver extends BroadcastReceiver {
MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if(action.equals("android.intent.action.ACTION_POWER_CONNECTED")){
        Toast.makeText(context,"charging lag gaya",Toast.LENGTH_LONG).show();
        mp=MediaPlayer.create(context,R.raw.littlethings);
        mp.start();
        }
        else if(action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")){
            Toast.makeText(context,"charging hat gaya",Toast.LENGTH_LONG).show();
            mp=MediaPlayer.create(context,R.raw.morethanthis);
            mp.start();
        }

    }
}
