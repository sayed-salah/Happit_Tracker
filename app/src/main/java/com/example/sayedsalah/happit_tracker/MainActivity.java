package com.example.sayedsalah.happit_tracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler = null;
    private ArrayList<Contact> contactsList = null;
    private RecyclerView recyclerView = null;
    private CustomAdapter customAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Contact mohamed = new Contact();
        mohamed.setContactName(" walking the dog");
        mohamed.setPhoneNumber(2);

        Contact sayed = new Contact();
        sayed.setContactName("taking any medications");
        sayed.setPhoneNumber(4);

        databaseHandler = new DatabaseHandler(MainActivity.this);
        databaseHandler.insert(mohamed);
        databaseHandler.insert(sayed);

        contactsList = databaseHandler.getAllContacts();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        customAdapter = new CustomAdapter(MainActivity.this, contactsList);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
    }
}
