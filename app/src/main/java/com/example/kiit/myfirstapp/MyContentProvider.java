package com.example.kiit.myfirstapp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    public MyContentProvider() {
    }

    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        Context c=getContext();
        SQLiteDatabase db=c.openOrCreateDatabase("rcpl_db",c.MODE_PRIVATE,null);
        int x=db.update("Student",values,selection,selectionArgs);
        return  x;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Context c=getContext();
        SQLiteDatabase db=c.openOrCreateDatabase("rcpl_db",c.MODE_PRIVATE,null);
        int x=db.delete("Student",selection,selectionArgs);
        return  x;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Context c=getContext();
        SQLiteDatabase db=c.openOrCreateDatabase("rcpl_db",c.MODE_PRIVATE,null);
        db.insert("Student",null,values);
        return uri;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Context c=getContext();
        SQLiteDatabase db=c.openOrCreateDatabase("rcpl_db",c.MODE_PRIVATE,null);
        Cursor cur=db.query("Student",projection,selection,selectionArgs,null,null,null);
        return cur;
    }
}
