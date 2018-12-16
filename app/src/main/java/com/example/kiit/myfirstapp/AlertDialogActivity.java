package com.example.kiit.myfirstapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AlertDialogActivity extends AppCompatActivity {
String selectedColor;
ArrayList al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    public void simpleDialog(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.cat);
        builder.setTitle("RCPL");
        builder.setMessage("Do you want to join RCPL?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this,"Yes clicked",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this,"No clicked",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    public void radioDialog(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.cat);
        builder.setTitle("Choose your favourite colour");
        final String[] s={"Blue","Red","Green","Yellow"};
        builder.setSingleChoiceItems(s, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                selectedColor=s[i];
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this,selectedColor,Toast.LENGTH_LONG).show();
            }
        });
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this,"No favourite colour",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    public void checkDialog(View view) {
        al=new ArrayList();
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.cat);
        builder.setTitle("Select you language");
        final String[] lang={"Hindi","Bengali","English","Tamil","French"};
        builder.setMultiChoiceItems(lang, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
            al.add(lang[i]);
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this,""+al,Toast.LENGTH_LONG).show();
            }
        });
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this,"Cancel selected",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    public void listDialog(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.cat);
        builder.setTitle("Select you college");
        final String[] s={"KIIT","IIT","NIT","VIT","SRM"};
        builder.setItems(s, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this,s[i],Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    public void customDialog(View view) {
        final Dialog d=new Dialog(this);
        d.setContentView(R.layout.custom);
        final EditText et1,et2;
        et1=d.findViewById(R.id.editText1);
        et2=d.findViewById(R.id.editText2);
        Button b1,b2;
        b1=d.findViewById(R.id.button1);
        b2=d.findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=et1.getText().toString();
                String m=et2.getText().toString();
                Toast.makeText(AlertDialogActivity.this,n+"-"+m,Toast.LENGTH_LONG).show();
                d.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AlertDialogActivity.this,"Cancel",Toast.LENGTH_LONG).show();
               d.dismiss();
            }
        });
        d.show();
    }

    @Override
    public void onBackPressed() {
        final Dialog d=new Dialog(this);
        d.setContentView(R.layout.custom1);
        Button b1,b2;
        b1=d.findViewById(R.id.button23);
        b2=d.findViewById(R.id.button24);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
    }
}
