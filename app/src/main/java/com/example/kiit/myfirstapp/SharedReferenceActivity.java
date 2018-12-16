package com.example.kiit.myfirstapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SharedReferenceActivity extends AppCompatActivity {
EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_reference);
        et=findViewById(R.id.editText13);
        SharedPreferences sp=getSharedPreferences("Rcpl",MODE_PRIVATE);
        String msg=sp.getString("data","");
        et.setText(msg);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp=getSharedPreferences("Rcpl",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("data",et.getText().toString());
        editor.commit();
    }
}
