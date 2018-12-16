package com.example.kiit.myfirstapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowDataActivity extends AppCompatActivity {
ListView lv;
SQLiteDatabase db;
ArrayList al;
String s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        lv=findViewById(R.id.listView1);
        al=new ArrayList();
        db=openOrCreateDatabase("rcpl_db",MODE_PRIVATE,null);
        String query="select * from Student";
        Cursor c=db.rawQuery(query,null);
        while(c.moveToNext()){
             s1=c.getString(0);
             s2=c.getString(1);
             s3=c.getString(2);
             String data=s1+" -- "+s2+" -- "+s3;
            al.add(data);
            registerForContextMenu(lv);

        }
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.showmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id=item.getItemId();
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int j=info.position;
        switch (id){
            case R.id.item1:{
                Intent i=new Intent(this,InsertDataActivity.class);
                startActivity(i);
            }break;
            case R.id.item2:{Intent i=new Intent(this,UpdateActivity.class);
                // i.putExtra("id",s1);
                // i.putExtra("mob",s3);

                startActivity(i);
            }
            break;
            case R.id.item3:{
                Intent i=new Intent(this,DeleteActivity.class);
                startActivity(i);
            }

        }


        return super.onContextItemSelected(item);
    }
}
