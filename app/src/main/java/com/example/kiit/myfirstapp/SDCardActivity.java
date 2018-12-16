package com.example.kiit.myfirstapp;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SDCardActivity extends AppCompatActivity {
EditText et1,et2;
File f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);
        et1=findViewById(R.id.editText1);
        et2=findViewById(R.id.editText2);
        f= Environment.getExternalStorageDirectory();

    }

    public void writedata(View view) {
        String name=et1.getText().toString();
        String mobile=et2.getText().toString();
        FileOutputStream fos=null;
        String data=name+" -- "+mobile+"\n";
        File f2=new File(f,"rcpl.txt");
        try {
            f2.createNewFile();
        } catch (IOException e) {
            Toast.makeText(this,"Error: "+e,Toast.LENGTH_LONG).show();
        }
        try {
            fos=new FileOutputStream(f2,true);
            fos.write(data.getBytes());
            Toast.makeText(this,"Data written",Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this,"Error 2: "+e,Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this,"Error 3: "+e,Toast.LENGTH_LONG).show();
        }
        finally{
            try {
            fos.close();
        } catch (IOException e) {
            Toast.makeText(this,"Error 4: "+e,Toast.LENGTH_LONG).show();
        }
        }
    }

    public void readdata(View view) {
        FileInputStream fis=null;
        File f2=new File(f,"rcpl.txt");
        String data="";
        try {
            fis=new FileInputStream(f2);
            while(fis.available()>0){
                data=data+(char)fis.read();
            }
            Toast.makeText(this,data,Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this,"Error: "+e,Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this,"Error 2: "+e,Toast.LENGTH_LONG).show();

        }
        finally {
            try {
                fis.close();
            } catch (IOException e) {
                Toast.makeText(this,"Error 3: "+e,Toast.LENGTH_LONG).show();
            }
        }

    }
}
