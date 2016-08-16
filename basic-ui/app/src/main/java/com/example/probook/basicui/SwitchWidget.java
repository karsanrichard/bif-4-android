package com.example.probook.basicui;

import android.content.Intent;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class SwitchWidget extends AppCompatActivity {

    Button btnback;
    Button btnpoint;
    Button btnnext;
    TextView tvswitch;
    TextView tvvib;
    Switch swone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_widget);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        btnback = (Button) findViewById(R.id.btnback);
        btnpoint = (Button) findViewById(R.id.btnpoint);
        btnnext = (Button) findViewById(R.id.btnnext);
        tvswitch = (TextView) findViewById(R.id.tvswitch);
        tvvib = (TextView) findViewById(R.id.tvvib);
        swone = (Switch) findViewById(R.id.swone);

        tvvib.setVisibility(View.INVISIBLE);
        tvswitch.setVisibility(View.INVISIBLE);

        swone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                    tvswitch.setText("Manchester United Fan");
                    tvswitch.setVisibility(View.VISIBLE);
                }else{
                    tvswitch.setText("Still a Manchester United Fan");
                    tvswitch.setVisibility(View.VISIBLE);

                }
            }
        });

        BackButton();
        PointButton();
        NextButton();

    }

    public void Vibrator(View view){
        boolean checked = ((ToggleButton)view).isChecked();
        if(checked){
            tvvib.setText("Vibrate On");
            tvvib.setVisibility(view.VISIBLE);
        }else{
            tvvib.setText("Vibrate Off");
        }
    }


    public void BackButton(){
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentback = new Intent("com.example.probook.basicui.ButtonWidgets");
                startActivity(intentback);
            }
        });
    }

    public void PointButton(){
        btnpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SwitchWidget.this, "The switch is one way to selected one option or function...", Toast.LENGTH_LONG).show();
                Toast.makeText(SwitchWidget.this, "Also the toggle button, but the switch is more fun", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void NextButton(){
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentnext = new Intent("com.example.probook.basicui.BarWidgets");
                startActivity(intentnext);
            }
        });
    }




}
