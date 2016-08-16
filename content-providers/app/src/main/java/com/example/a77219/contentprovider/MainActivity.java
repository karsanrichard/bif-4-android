package com.example.a77219.contentprovider;

import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String namedir="";//initial string for storage of names for iteration
    String phonedir="";

    String name_array[];//for exploded result from namedir
    String phone_array[];

    ListView contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*List view to display contact names and number on click*/
        contactList = (ListView) findViewById(R.id.listOfContacts);

        /*Must have FOUR null values after*/
        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        //Cursor object (Object that holds result from ContactsContract)
        //Provides random read-write access to the result set returned by a database query.

        while(phones.moveToNext()){
            //Common Data Kinds - Container for definitions of common data types stored in the ContactsContract.Data table
            //Contact name
            String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            //Contact number
            String number = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            //Addition to dir string
            if(name != null){
                namedir += name + ",";
                phonedir += number + ",";
            }
            //completed addition of numbers to dir string
        }
        //closing of cursor
        phones.close();

        name_array = namedir.split(",");
        phone_array = phonedir.split(",");

        //creation of array addapter and addition of values to it
        //allows array to be written into a list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,name_array);
        //binding of adapter to existent list view declared above
        contactList.setAdapter(adapter);
        //setting onclick listener for toast with number
        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = phone_array[position];
                Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addContactsView(View view){
        setContentView(R.layout.add_contacts);
    }//calls the add view

    public void addContact(View view){
        //An Intent is a messaging object you can use to request an action from another app component.
        //Creation of intent to insert the new contact
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        //Setting of the MIME type to match provider
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

        //Assigning variables values from text fields
        EditText new_name = (EditText)findViewById(R.id.newName);
        EditText new_email = (EditText)findViewById(R.id.newEmail);
        EditText new_phone = (EditText) findViewById(R.id.newPhone);

        //DATA INSERTION
        //Intent is created,and inserted into contact fields in add contact interface
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL,new_email.getText())
                .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                .putExtra(ContactsContract.Intents.Insert.PHONE,new_phone.getText())
                .putExtra(ContactsContract.Intents.Insert.NAME,new_name.getText())
                .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK);

        startActivity(intent);//Make the magic happen
    }
}

