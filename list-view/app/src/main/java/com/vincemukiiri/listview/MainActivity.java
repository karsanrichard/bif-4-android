package com.vincemukiiri.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> data = new ArrayList<>();
        String[] dataItems = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen"};
        data.addAll(Arrays.asList(dataItems));

        ArrayAdapter<String> numbersAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(android.R.id.list);
        if (listView != null) {
            listView.setAdapter(numbersAdapter);
        }
    }
}
