package com.example.kiit.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopUpMenuActivity extends AppCompatActivity implements View.OnClickListener {
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_menu);
        b=findViewById(R.id.button1);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        PopupMenu popupMenu=new PopupMenu(this,view);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.popupmenu,popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id=menuItem.getItemId();
                switch (id){
                    case R.id.item1:Toast.makeText(PopUpMenuActivity.this,"call clicked",Toast.LENGTH_LONG).show();
                    break;
                    case R.id.item2:Toast.makeText(PopUpMenuActivity.this,"delete clicked",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.item3:Toast.makeText(PopUpMenuActivity.this,"update clicked",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.item4:Toast.makeText(PopUpMenuActivity.this,"sms clicked",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.item5:Toast.makeText(PopUpMenuActivity.this,"add clicked",Toast.LENGTH_LONG).show();
                        break;



                }
                return false;
            }
        });
    }
}
