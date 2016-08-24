package com.example.mike.ussd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mike on 23-Aug-16.
 */
public class MyReceiver extends BroadcastReceiver {

    MainActivity mInst = MainActivity.instance();

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("message");
//        Toast.makeText(context, message, Toast.LENGTH_LONG).show();

        Log.d("XXXX", "Intent received");

        TextView textView = (TextView) mInst.findViewById(R.id.editText);
        textView.setText(message);

    }

}