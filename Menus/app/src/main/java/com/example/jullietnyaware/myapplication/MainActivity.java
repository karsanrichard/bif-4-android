package com.example.jullietnyaware.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button menu=(Button)findViewById(R.id.buttonContext);
        registerForContextMenu(menu);
        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                 System.out.println("clicked once");
            }
        });

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Copy to dashboard");
        menu.add(0, v.getId(), 0, "Share via facebook");
        menu.add(0, v.getId(), 0, "share with  contacts");
    }

    public void ShowPopUp(View view)
    {
        PopupMenu popupMenu = new PopupMenu(this,view);
        MenuInflater menuInflater=popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.popup_actions,popupMenu.getMenu());
        popupMenu.show();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle()=="Copy to dashboard"){function1(item.getItemId());}
        else if(item.getTitle()=="Share via facebook"){function2(item.getItemId());}
        else if(item.getTitle()=="Share with contacts"){function3(item.getItemId());}
        else {return false;}
        return true;
    }

    public void function1(int id){
        Toast.makeText(this, "Copying to dashboard", Toast.LENGTH_SHORT).show();
    }
    public void function2(int id){
        Toast.makeText(this, "sharing via facebook?", Toast.LENGTH_SHORT).show();
    }
    public void function3(int id){
        Toast.makeText(this, "Sharing with contacts", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.Account:
                Toast.makeText(this, "How do you want your account", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.Profile:
                Toast.makeText(this, "Change profile Details", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.Status:
                Toast.makeText(this, "View previous Uploads", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.Blocked:
                Toast.makeText(this, "View recipes downloaded", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
