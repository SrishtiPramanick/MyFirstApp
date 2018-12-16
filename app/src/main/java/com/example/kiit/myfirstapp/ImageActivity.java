package com.example.kiit.myfirstapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener {
ImageView iv;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        b1=findViewById(R.id.button);
        iv=findViewById(R.id.imageView2);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle b=data.getExtras();
            Bitmap bitmap=(Bitmap)b.get("data");
            iv.setImageBitmap(bitmap);
        }
        else{
            Toast.makeText(this,"Oop! No picture taken",Toast.LENGTH_LONG);
        }
    }
}
