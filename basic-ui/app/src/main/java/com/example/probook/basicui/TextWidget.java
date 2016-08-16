package com.example.probook.basicui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.Toast;

public class TextWidget extends AppCompatActivity {

    Button btnback;
    Button btnpoint;
    Button btnnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_widget);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btnback = (Button) findViewById(R.id.btnback);
        btnpoint = (Button) findViewById(R.id.btnpoint);
        btnnext = (Button) findViewById(R.id.btnnext);

        BackButton();
        PointButton();
        NextButton();


    }

    public void BackButton(){
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentback = new Intent(TextWidget.this,MainActivity.class);
                startActivity(intentback);
            }
        });
    }

    public void PointButton(){
        btnpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TextWidget.this, "It is best to use sp (Scale Independent Pixels) for text...", Toast.LENGTH_LONG).show();
                Toast.makeText(TextWidget.this, "and dp (Density Independent Pixels) for layout arrangements", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void NextButton(){
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentnext = new Intent("com.example.probook.basicui.ButtonWidgets");
                startActivity(intentnext);
            }
        });
    }


}
