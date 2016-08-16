package com.example.programming.proximityalerts;


import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by Programming on 8/10/2016.
 */
public class ProximityAlertActivity extends AppCompatActivity {

    private static final String USE_ANDROID_PROXIMITY_TYPE_KEY = "useAndroidProximityTypeKey";

    private LocationManager locationManager;
    private PendingIntent pendingIntent;
    private SharedPreferences preferences;
    private RadioButton androidProximityTypeRadioButton;
    private Button setProximityAlert;
    private Button clearProximityAlert;
    private double latitude = Double.MAX_VALUE;
    private double longitude = Double.MAX_VALUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proximity_alert);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        pendingIntent = ProximityPendingIntentFactory.createPendingIntent(this);

        preferences = getPreferences(MODE_PRIVATE);
        androidProximityTypeRadioButton =
                (RadioButton) findViewById(R.id.androidProximityAlert);

        setProximityAlert = (Button) findViewById(R.id.setProximityAlert);
        clearProximityAlert = (Button) findViewById(R.id.clearProximityAlert);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (preferences.getBoolean(USE_ANDROID_PROXIMITY_TYPE_KEY, true)) {
            androidProximityTypeRadioButton.setChecked(true);
        } else {
            ((RadioButton) findViewById(R.id.customProximityAlert)).setChecked(true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.removeProximityAlert(pendingIntent);
        preferences.edit().putBoolean(USE_ANDROID_PROXIMITY_TYPE_KEY, androidProximityTypeRadioButton.isChecked()).commit();
    }

    public void onSetProximityAlertClick(View view) {
        EditText radiusView = (EditText) findViewById(R.id.radiusValue);
        int radius =
                Integer.parseInt(radiusView.getText().toString());

        if (androidProximityTypeRadioButton.isChecked()) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.addProximityAlert(latitude, longitude, radius, -1, pendingIntent);
        } else {
            Criteria criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_COARSE);
            Intent intent = new Intent(this, com.example.programming.proximityalerts.ProximityAlertService.class);
            intent.putExtra(ProximityAlertService.LATITUDE_INTENT_KEY, latitude);
            intent.putExtra(ProximityAlertService.LONGITUDE_INTENT_KEY, longitude);
            intent.putExtra(ProximityAlertService.RADIUS_INTENT_KEY, (float) radius);
            startService(intent);
        }

        setProximityAlert.setEnabled(false);
        clearProximityAlert.setEnabled(true);
    }

    public void onClearProximityAlertClick(View view) {
        if (androidProximityTypeRadioButton.isChecked()) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.removeProximityAlert(pendingIntent);
        }

        setProximityAlert.setEnabled(true);
        clearProximityAlert.setEnabled(false);
    }

    public void onSetLocationClick(View view)
    {
        startActivityForResult(new Intent(this, GeocodeActivity.class), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK
                && data != null
                && data.hasExtra("name")
                && data.hasExtra("latitude")
                && data.hasExtra("longitude"))
        {
            latitude = data.getDoubleExtra("latitude", Double.MAX_VALUE);
            longitude = data.getDoubleExtra("longitude", Double.MAX_VALUE);

            ((TextView)findViewById(R.id.locationValue)).setText(data.getStringExtra("name"));
            ((TextView)findViewById(R.id.latitudeValue)).setText(String.valueOf(latitude));
            ((TextView)findViewById(R.id.longitudeValue)).setText(String.valueOf(longitude));

            setProximityAlert.setEnabled(true);
            clearProximityAlert.setEnabled(false);
        }
    }
}
