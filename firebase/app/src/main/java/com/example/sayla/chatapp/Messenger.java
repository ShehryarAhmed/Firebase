package com.example.sayla.chatapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by sayla on 04/12/2016.
 */
public class Messenger extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messenger);

        ListView mlistView = (ListView) findViewById(R.id.list);



    }
}
