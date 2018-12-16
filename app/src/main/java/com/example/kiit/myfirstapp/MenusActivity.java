package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.simple_menu,menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id=item.getItemId();
       switch(id){
           case R.id.item1:Toast.makeText(this,"Add clicked",Toast.LENGTH_LONG).show();
           break;
           case R.id.item2: Toast.makeText(this,"Edit clicked",Toast.LENGTH_SHORT).show();
           break;
           case R.id.item3:Toast.makeText(this,"Delete clicked",Toast.LENGTH_LONG).show();
           break;
           case R.id.item4:Toast.makeText(this,"Share clicked",Toast.LENGTH_LONG).show();
       }

        return super.onOptionsItemSelected(item);
    }
}
