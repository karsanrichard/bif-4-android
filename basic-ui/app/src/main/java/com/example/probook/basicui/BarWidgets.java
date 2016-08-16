package com.example.probook.basicui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class BarWidgets extends AppCompatActivity {

    SeekBar skbar;
    RatingBar rtbar;

    Button btndownload;
    Button btnback;
    Button btnpoint;
    Button btnhome;
    TextView tvseek;
    TextView tvrating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_widgets);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnback= (Button) findViewById(R.id.btnback);
        btnpoint= (Button) findViewById(R.id.btnpoint);
        btnhome= (Button) findViewById(R.id.btnhome);
        btndownload = (Button) findViewById(R.id.btndownload);

        tvseek = (TextView) findViewById(R.id.tvseek);
        tvrating = (TextView) findViewById(R.id.tvrating);

        skbar = (SeekBar) findViewById(R.id.skbar);
        rtbar = (RatingBar) findViewById(R.id.rtbar);

        BackButton();
        PointButton();
        HomeButton();
        GenerateProgress();
        SeekingBar();
        Rating();
    }

    public void GenerateProgress(){
        btndownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog pda = new ProgressDialog(BarWidgets.this);
                pda.setTitle("Virus downloading");
                pda.setMessage("Please wait...");
                pda.show();
            }
        });
    }

    public void SeekingBar(){
        tvseek.setText("Current: " + skbar.getProgress() + " / " + skbar.getMax());

        skbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progessstatus;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                progessstatus = i;
                tvseek.setText("Current: " + progessstatus + " / " + skbar.getMax());
//                Toast.makeText(BarWidgets.this,"Seek Bar in onProgressChanged state",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(BarWidgets.this,"Seek Bar in onStartTrackingTouch state",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tvseek.setText("Current: " + progessstatus + " / " + skbar.getMax());
                Toast.makeText(BarWidgets.this,"Seek Bar in onStopTrackingTouch state",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void Rating(){

        rtbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                tvrating.setText(String.valueOf(v));
            }
        });
    }

    public void BackButton(){
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentback = new Intent("com.example.probook.basicui.SwitchWidget");
                startActivity(intentback);
            }
        });
    }

    public void PointButton(){
        btnpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BarWidgets.this, "Progress Bar allows user to wait thinking that something is happening...", Toast.LENGTH_LONG).show();
                Toast.makeText(BarWidgets.this, "Seek Bar can be used to regulate something, volume, price etc.", Toast.LENGTH_LONG).show();
                Toast.makeText(BarWidgets.this, "Rating Bar is for rating this presentation", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void HomeButton(){
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentnext = new Intent(BarWidgets.this,MainActivity.class);
                startActivity(intentnext);
            }
        });
    }

}
