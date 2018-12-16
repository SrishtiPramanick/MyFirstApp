package com.example.kiit.myfirstapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CustomListActivity extends AppCompatActivity {
ListView lv;
String[] name={"Ankita","Sneha","Vedika","Sammy"};
String[] phone={"9866756987","9087986346","9870897649","9708635789"};
int[] image={R.drawable.cat,R.drawable.dog,R.drawable.cat,R.drawable.dog};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        lv=findViewById(R.id.listView1);
        MyArrayAdapter adapter=new MyArrayAdapter(this,android.R.layout.simple_list_item_1,name);
        lv.setAdapter(adapter);
    }

    private class MyArrayAdapter extends ArrayAdapter {
        public MyArrayAdapter(Context c, int x, String[] name) {
            super(c,x,name);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater li= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View v=li.inflate(R.layout.custom_list,parent,false);
            ImageView iv=v.findViewById(R.id.imageView);
            TextView tv1=v.findViewById(R.id.textView1);
            TextView tv2=v.findViewById(R.id.textView2);
            iv.setImageResource(image[position]);
            tv1.setText(name[position]);
            tv2.setText(phone[position]);
            return v;
        }
    }
}
