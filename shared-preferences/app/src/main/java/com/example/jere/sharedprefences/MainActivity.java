package com.example.jere.sharedprefences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText name;
    private TextView txt_display;
    private Button btn_save;
    private static final String PREF_NAME="myprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.editname);
        txt_display=(TextView)findViewById(R.id.txt_show_name);

        btn_save=(Button)findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences myprefs=getSharedPreferences(PREF_NAME,0);
                SharedPreferences.Editor editor=myprefs.edit();
//                checking if  the field is empty
                if(name.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please Enter a name",Toast.LENGTH_LONG).show();
                }else{
                    editor.putString("name",name.getText().toString());
                    editor.commit();
                }
            }
        });
    //getting   data back
        SharedPreferences prefs= getSharedPreferences(PREF_NAME,0);
        if(prefs.contains("name")){
            String Uname=prefs.getString("name","Not found");
            txt_display.setText("You are " + Uname);

        }else{
            txt_display.setText("");
        }
    }


}
