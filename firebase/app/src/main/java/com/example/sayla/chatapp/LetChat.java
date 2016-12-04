package com.example.sayla.chatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by sayla on 04/12/2016.
 */
public class LetChat extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letchat);

        Button letchat = (Button) findViewById(R.id.addButton);

        letchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LetChat.this,Messenger.class);

                startActivity(intent);
            }
        });

    }
}
