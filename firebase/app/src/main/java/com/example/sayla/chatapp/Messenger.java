package com.example.sayla.chatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
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
<<<<<<< HEAD
=======

    FirebaseAuth mFirebaseAuth;

    FirebaseAuth.AuthStateListener mAuthStateListener;

>>>>>>> d5a83c5919af1e19182d73ad6686df36bfa3d20e
    EditText mMessage;
    private DatabaseReference messagesDB;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messenger);
<<<<<<< HEAD
=======

        mFirebaseAuth = FirebaseAuth.getInstance();

        final Button mMessagesender = (Button) findViewById(R.id.sendmessage);

        mMessagesender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMessage = (EditText) findViewById(R.id.messages);

                String getmessage = mMessage.getText().toString().trim();

                writenewuser(getmessage);

            }
        });


>>>>>>> d5a83c5919af1e19182d73ad6686df36bfa3d20e
        mdatabase = FirebaseDatabase.getInstance();
        messagesDB  = mdatabase.getReference("conversation");
<<<<<<< HEAD
        messagesDB.child("abc").push().setValue("now again Send Data");
        messagesDB.child("person").push().setValue("person");
    }
    }
=======
        messagesDB.child("abc").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d("TAGSG",dataSnapshot.getValue().toString());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {



            }
        };
        databaseReference.setValue("Hello World");

    }


    private void writenewuser(String message){
        messagesDB.child("abc").push().setValue(message);
//        mdatabase.getReference().push().setValue(message);
    }


}
>>>>>>> d5a83c5919af1e19182d73ad6686df36bfa3d20e
