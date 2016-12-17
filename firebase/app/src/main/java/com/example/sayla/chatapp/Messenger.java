package com.example.sayla.chatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by sayla on 04/12/2016.
 */
public class Messenger extends AppCompatActivity{
    FirebaseDatabase mdatabase;
    EditText mMessage;
    private DatabaseReference messagesDB;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messenger);
        mdatabase = FirebaseDatabase.getInstance();
        messagesDB  = mdatabase.getReference("conversation");
        messagesDB.child("abc").push().setValue("now again Send Data");
        messagesDB.child("person").push().setValue("person");
    }
    }
