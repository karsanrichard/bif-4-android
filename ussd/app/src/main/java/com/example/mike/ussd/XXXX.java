package com.example.mike.ussd;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Intent;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

/**
 * Created by Mike on 23-Aug-16.
 */
public class XXXX extends AccessibilityService {

    public static String TAG = "XXXX";

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.d(TAG, "onAccessibilityEvent");
        String text = event.getText().toString();

        if (event.getClassName().equals("android.app.AlertDialog")) {
            Log.d(TAG, "Alert Dialog");
            performGlobalAction(GLOBAL_ACTION_BACK);
            Log.d(TAG, text);
            Intent intent = new Intent(getBaseContext(), MyReceiver.class);
            intent.putExtra("message", text);
            // write a broad cast receiver and call sendbroadcast() from here, if you want to parse the message for balance, date
            sendBroadcast(intent);

        }

    }

    @Override
    public void onInterrupt() {
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.d(TAG, "onServiceConnected");
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.flags = AccessibilityServiceInfo.DEFAULT;
        info.packageNames = new String[]{"com.android.phone"};
        info.eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        setServiceInfo(info);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("XXXX", "Start Command");
        return super.onStartCommand(intent, flags, startId);
    }
}

