package com.example.mike.ussd;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static MainActivity mInst;

    public static MainActivity instance() {
        return mInst;
    }

    // Get Safaricom balance(*144# for Safaricom)
    private void dailNumber(String code) {
        String ussdCode = "*" + code + Uri.encode("*");
        startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + ussdCode)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("XXXX", "LOH HERER");

        mInst = this;
    }

    public void getBalance(View view) {
        startService(new Intent(this, XXXX.class));
        Log.d("XXXX", "service");
        dailNumber("#*#4636#*#");
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        TextView txtView = new TextView(this);
        txtView = (TextView) findViewById(R.id.editText);
        txtView.setText(message);
    }
}
