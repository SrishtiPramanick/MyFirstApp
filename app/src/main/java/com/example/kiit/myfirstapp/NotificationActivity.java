package com.example.kiit.myfirstapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


    }

    public void simpleNotification(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(android.R.drawable.sym_call_missed);
        builder.setContentTitle("100 Missed Calls");
        builder.setContentText("Pappu");
        Intent i=new Intent(this,LoginActivity.class);
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addParentStack(LoginActivity.class);
        stackBuilder.addNextIntent(i);
        PendingIntent pi=PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);
        builder.setOngoing(true);

        Notification n = builder.build();
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(5, n);

    }

    public void bigNotification(View view) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.arrow);
        builder.setContentTitle("RCPL");
        builder.setContentText("Summer Training Program 2018");

        NotificationCompat.BigPictureStyle style=new android.support.v4.app.NotificationCompat.BigPictureStyle();
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.bg);
        style.bigLargeIcon(bitmap);
        Bitmap bitmap1=BitmapFactory.decodeResource(getResources(),R.drawable.cat);
        style.bigPicture(bitmap1);
        style.setBigContentTitle("KOLKATA");
        style.setSummaryText("see more");
        builder.setStyle(style);

        Intent i=new Intent(this,LoginActivity.class);
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addParentStack(LoginActivity.class);
        stackBuilder.addNextIntent(i);
        PendingIntent pi=PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);

        Notification n=builder.build();
        NotificationManager nm= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(6,n);
    }

    public void inboxNotification(View view) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.arrow);
        builder.setContentTitle("RCPL");
        builder.setContentText("Summer Training Program 2018");

        NotificationCompat.InboxStyle style=new android.support.v4.app.NotificationCompat.InboxStyle();
        style.addLine("This is my first line");
        style.addLine("This is my second line");
        style.addLine("This is my third line");
        style.addLine("This is my fourth line");
        style.setBigContentTitle("INBOX TYPE NOTIFICATION");
        style.setSummaryText("Summary Text");

        Intent i=new Intent(this,LoginActivity.class);
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addParentStack(LoginActivity.class);
        stackBuilder.addNextIntent(i);
        PendingIntent pi=PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);

        builder.setStyle(style);
        Notification n= builder.build();
        NotificationManager nm= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(6,n);
    }

    public void bigtextNotification(View view) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.arrow);
        builder.setContentTitle("RCPL");
        builder.setContentText("Summer Training Program 2018");

        NotificationCompat.BigTextStyle style=new android.support.v4.app.NotificationCompat.BigTextStyle();
        style.bigText("THIS IS BIG TEXT STYLE NOTIFICATION. HERE WE WILL SEE BIG LETTERS.THIS IS WHY IT IS CALLED BIG TEXT STYLE NOTIFICATION .THIS IS THE FIRST LINE.THIS IS THE SECOND LINE.THIS IS THE THISRD LINE.THIS IS THE LAST LINE.");
        style.setBigContentTitle("TITLE");
        style.setSummaryText("SUMMARY TEXT");

        Intent i=new Intent(this,LoginActivity.class);
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addParentStack(LoginActivity.class);
        stackBuilder.addNextIntent(i);
        PendingIntent pi=PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);

        builder.setStyle(style);
        Notification n= builder.build();
        NotificationManager nm= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(6,n);
    }

    public void actionNotification(View view) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.arrow);
        builder.setContentTitle("RCPL");
        builder.setContentText("Summer Training Program 2018");

        NotificationCompat.BigPictureStyle style=new android.support.v4.app.NotificationCompat.BigPictureStyle();
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.bg);
        style.bigLargeIcon(bitmap);
        Bitmap bitmap1=BitmapFactory.decodeResource(getResources(),R.drawable.cat);
        style.bigPicture(bitmap1);
        style.setBigContentTitle("KOLKATA");
        style.setSummaryText("see more");
        builder.setStyle(style);

        Intent i=new Intent(this,LoginActivity.class);
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addParentStack(LoginActivity.class);
        stackBuilder.addNextIntent(i);
        Intent i1=new Intent(this,MenuActivity.class);
        TaskStackBuilder stackBuilder1=TaskStackBuilder.create(this);
        stackBuilder1.addParentStack(MenuActivity.class);
        stackBuilder1.addNextIntent(i1);
        PendingIntent pi=PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        PendingIntent pi1=PendingIntent.getActivity(this,0,i1,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi1);

        NotificationCompat.Action action=new NotificationCompat.Action(android.R.drawable.sym_call_missed,"LOGIN",pi);
        NotificationCompat.Action action1=new NotificationCompat.Action(android.R.drawable.star_big_on,"MENU",pi1);
        builder.addAction(action);
        builder.addAction(action1);


        builder.setStyle(style);
        Notification n= builder.build();
        NotificationManager nm= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(6,n);
    }
}
