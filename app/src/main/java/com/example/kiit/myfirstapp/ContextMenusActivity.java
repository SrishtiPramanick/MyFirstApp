package com.example.kiit.myfirstapp;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ContextMenusActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
ListView lv;
    ArrayAdapter adapter;
    ArrayList al;
    ArrayList al2;
    int j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menus);
        al = new ArrayList();
        al2 = new ArrayList();
        al.add("Ankita");
        al.add("Sneha");
        al.add("Vedika");
        al.add("Sammy");
        al.add("Shivani");
        al2.add("9877676899");
        al2.add("7876550988");
        al2.add("7875549903");
        al2.add("7866609862");
        al2.add("6865509872");

       lv=findViewById(R.id.listView1);
      adapter =new ArrayAdapter(this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        registerForContextMenu(lv);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,""+al.get(i),Toast.LENGTH_LONG).show();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id=item.getItemId();
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        j=info.position;
        switch (id){
            case R.id.item1: {Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+al2.get(j)));
                startActivity(intent);}
            break;
            case R.id.item2:{al.remove(j);
            al2.remove(j);
            adapter.notifyDataSetChanged();
            }
                break;
            case R.id.item3:{final Dialog d=new Dialog(this);
                d.setContentView(R.layout.updatemenu);
                Button b1,b2;
                b1=d.findViewById(R.id.button26);
                b2=d.findViewById(R.id.button27);
                final EditText et1=d.findViewById(R.id.editText1);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        String s1=et1.getText().toString();
                        al2.set(j,s1);
                        d.dismiss();
                    }
                });
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        d.dismiss();
                    }
                });
                d.show();}
                break;
            case R.id.item4: {Intent i=new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:"+al2.get(j)));
                   i.putExtra("sms_body","I am in class");
                 startActivity(i);}
                break;
            case R.id.item5:{final Dialog d=new Dialog(this);
                d.setContentView(R.layout.addmenu);
                Button b1,b2;
                b1=d.findViewById(R.id.button28);
                b2=d.findViewById(R.id.button29);
                final EditText et1,et2;
                et1=d.findViewById(R.id.editText12);
                et2=d.findViewById(R.id.editText14);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {
                        String s1=et1.getText().toString();
                        String s2=et2.getText().toString();
                        al.add(s1);
                        al2.add(s2);
                        adapter.notifyDataSetChanged();
                        d.dismiss();
                    }
                });
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        d.dismiss();
                    }
                });
                d.show();
        }}

        return super.onContextItemSelected(item);
    }
}
