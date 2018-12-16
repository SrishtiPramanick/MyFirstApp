package com.example.kiit.myfirstapp;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {
ListView lv;
int i;
ArrayList al,al2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        lv=findViewById(R.id.listView);
        al=new ArrayList();
        al2=new ArrayList();
        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        ContentResolver cr=getContentResolver();
        Cursor c=cr.query(uri,null,null,null,null);
        int n=c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
        int m=c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
        while(c.moveToNext()){
            String s1=c.getString(n);
            String s2=c.getString(m);
            al2.add(s2);
            String d=s1+" -- "+s2;
            al.add(d);
        }
        while(al.get(i)!=null){

        }
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contactsmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id=item.getItemId();
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int j=info.position;
        switch(id){
            case R.id.item1:{Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+al2.get(j)));
                startActivity(intent);}
        }
        return super.onContextItemSelected(item);
    }
}
