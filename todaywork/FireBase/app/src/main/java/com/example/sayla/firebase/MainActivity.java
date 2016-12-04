package com.example.sayla.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase mdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        12
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");

        final EditText mfirstname = (EditText) findViewById(R.id.firstname);

        final EditText mlastname = (EditText) findViewById(R.id.firstname);

        Button madd = (Button) findViewById(R.id.addButton);

        madd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fname = mfirstname.getText().toString().trim();

                String lname = mlastname.getText().toString().trim();

                writenewuser(fname,lname);


            }
        });

        mdatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = mdatabase.getReference("user");

        databaseReference.setValue("Hello World");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    private void writenewuser(String fname,String lname){

        User muser = new User(fname,lname);

        mdatabase.getReference().push().setValue(muser);
    }

}
