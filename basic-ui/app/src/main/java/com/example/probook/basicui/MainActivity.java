package com.example.probook.basicui;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button btnbar;
    Button btnswitch;
    Button btntext;
    Button btnbuttons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This is an floating action bar... It does nothing, by the way", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        btnbar = (Button) findViewById(R.id.btnbar);
        btnswitch = (Button) findViewById(R.id.btnswitch);
        btntext = (Button) findViewById(R.id.btntext);
        btnbuttons = (Button) findViewById(R.id.btnbutton);

        BarWidget();
        SwitchWidget();
        TextWidget();
        ButtonWidget();
    }



    public void BarWidget(){
        btnbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentbar = new Intent("com.example.probook.basicui.BarWidgets");
                startActivity(intentbar);
            }
        });
    }

    public void SwitchWidget(){
        btnswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentswitch = new Intent("com.example.probook.basicui.SwitchWidget");
                startActivity(intentswitch);
            }
        });
    }

    public void TextWidget(){
        btntext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenttext = new Intent("com.example.probook.basicui.TextWidget");
                startActivity(intenttext);
            }
        });
    }

    public void ButtonWidget(){
        btnbuttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentbutton = new Intent("com.example.probook.basicui.ButtonWidgets");
                startActivity(intentbutton);
            }
        });
    }








    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search) {
            Intent intet = new Intent();
            PendingIntent pdi = PendingIntent.getActivity(MainActivity.this,0,intet,0);
            Notification noti = new Notification.Builder(MainActivity.this)
                    .setTicker("Come Search")
                    .setContentTitle("No Searching")
                    .setContentText("There is nothing to search for")
                    .setSmallIcon(R.drawable.ic_menu_send)
                    .setContentIntent(pdi).getNotification();

            noti.flags = Notification.FLAG_AUTO_CANCEL;
            NotificationManager nm =(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            nm.notify(0,noti);
        }else if(id == R.id.profile){
            Intent intet = new Intent();
            PendingIntent pdi = PendingIntent.getActivity(MainActivity.this,0,intet,0);
            Notification noti = new Notification.Builder(MainActivity.this)
                    .setTicker("Profile")
                    .setContentTitle("Profile: You")
                    .setContentText("Student of Mobile Computing")
                    .setSmallIcon(R.drawable.ic_menu_gallery)
                    .setContentIntent(pdi).getNotification();

            noti.flags = Notification.FLAG_AUTO_CANCEL;
            NotificationManager nm =(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            nm.notify(0,noti);
        }else if(id == R.id.settings){
            Toast.makeText(MainActivity.this, "But there is nothing to set. Enjoy as it is !!!", Toast.LENGTH_LONG).show();
        }else if(id == R.id.login){
            Toast.makeText(MainActivity.this, "Unable to carry out function. Try logging out first", Toast.LENGTH_LONG).show();
        }else if(id == R.id.logout){
            Toast.makeText(MainActivity.this, "How ???", Toast.LENGTH_LONG).show();
            Toast.makeText(MainActivity.this, "Login in first", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_linear) {

            Toast.makeText(MainActivity.this, "Linear Layout", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_relative) {

            Toast.makeText(MainActivity.this, "Relative Layout", Toast.LENGTH_SHORT).show();

            Intent relativeintent = new Intent("com.example.probook.basicui.RelativeLayout");
            startActivity(relativeintent);

        } else if (id == R.id.nav_table) {

            Intent tableintent = new Intent("com.example.probook.basicui.TableLayout");
            startActivity(tableintent);

        } else if (id == R.id.nav_option) {

            Toast.makeText(MainActivity.this, "For what now?", Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, "Eeee ?", Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, "For what ?", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_exit) {

            Toast.makeText(MainActivity.this, "You will never leave.", Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, "Just don't press back button", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
