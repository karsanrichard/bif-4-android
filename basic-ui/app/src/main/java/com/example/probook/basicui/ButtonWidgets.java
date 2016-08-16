package com.example.probook.basicui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ButtonWidgets extends AppCompatActivity {

    Button btnback;
    Button btnpoint;
    Button btnnext;
    TextView tvradios;
    TextView tvboxes;

    ArrayList<String> selections = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_widgets);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnback = (Button) findViewById(R.id.btnback);
        btnpoint = (Button) findViewById(R.id.btnpoint);
        btnnext = (Button) findViewById(R.id.btnnext);
        tvradios = (TextView) findViewById(R.id.tvradios);
        tvboxes = (TextView) findViewById(R.id.tvboxes);

        tvradios.setEnabled(false);
        tvboxes.setEnabled(false);


        BackButton();
        PointButton();
        NextButton();
    }

    public void selectFood(View view){
         boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()){
            case R.id.st:
                if(checked){
                    tvradios.setText("Cafetria Selected");
                    tvradios.setEnabled(true);
                }else{
                    tvradios.setText("Non Selected");
                    tvradios.setEnabled(false);
                }
                break;

            case R.id.sn:
                if(checked){
                    tvradios.setText("Snackbar Selected");
                    tvradios.setEnabled(true);
                }else{
                    tvradios.setText("Non Selected");
                    tvradios.setEnabled(false);
                }
                break;

            case R.id.si:
                if(checked){
                    tvradios.setText("Siwaka Selected");
                    tvradios.setEnabled(true);
                }else{
                    tvradios.setText("Non Selected");
                    tvradios.setEnabled(false);
                }
                break;

            default:

                break;
        }
    }
    public void selectUnit(View view){
        String all_units = "";
        boolean checks = ((CheckBox) view).isChecked();

        switch (view.getId()){
            case R.id.unit1:
                if (checks){
                    selections.add("DataStuctures");
                    tvboxes.setEnabled(true);
                }else{
                    selections.remove("DataStuctures");
                }
                break;
            case R.id.unit2:
                if (checks){
                    selections.add("ComputationalModels");
                    tvboxes.setEnabled(true);
                }else{
                    selections.remove("ComputationalModels");
                }
                break;
            case R.id.unit3:
                if (checks){
                    selections.add("AdvancedCplusplus");
                    tvboxes.setEnabled(true);
                }else{
                    selections.remove("AdvancedCplusplus");
                }
                break;
            default:
                if (checks){
                    selections.add("Non selected");
                    tvboxes.setEnabled(false);
                }else{
                    selections.remove("Non selected");
                    tvboxes.setEnabled(true);
                }
                break;
        }

        for(String Selects : selections){
            all_units = all_units + Selects + "\t";

        }
        tvboxes.setEnabled(true);
        tvboxes.setText(all_units);
    }


    public void BackButton(){
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentback = new Intent("com.example.probook.basicui.TextWidget");
                startActivity(intentback);
            }
        });
    }

    public void PointButton(){
        btnpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonWidgets.this, "Radio Buttons makes the user pick one option...", Toast.LENGTH_SHORT).show();
                Toast.makeText(ButtonWidgets.this, "Checkbox is not a button, but user can pick multiple options", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void NextButton(){
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentnext = new Intent("com.example.probook.basicui.SwitchWidget");
                startActivity(intentnext);
            }
        });
    }

}
