package com.example.sayla.chatapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference mDatabaseReference;

    private FirebaseAuth mFirebaseAuth;

    private EditText mEmail, mPassword;

    Button mSignUp, mLogin;

    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        mFirebaseAuth = FirebaseAuth.getInstance();

        mEmail = (EditText) findViewById(R.id.Email);

        mPassword = (EditText) findViewById(R.id.Password);

        mSignUp = (Button) findViewById(R.id.msign_up);


        mLogin = (Button) findViewById(R.id.mlogin);

        mSignUp.setOnClickListener(this);

        mLogin.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        if(mFirebaseAuth.getCurrentUser() != null){
            onAuthsucess(mFirebaseAuth.getCurrentUser());
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    public void onClick(View v) {
        int i = v.getId();

        if (i == R.id.mlogin) {
            login();
        }
       else if (i == R.id.msign_up) {
            signUp();
        }
    }

    private void login() {
        Log.d("Login", "Signin");
        if (!validForm()) {
            return;
        }
        showDailogbox();
        String getEmail = mEmail.getText().toString().trim();
        String getPassword = mPassword.getText().toString().trim();
        mFirebaseAuth.signInWithEmailAndPassword(getEmail,getPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                hideProgressdialog();
            if(task.isSuccessful()){
             onAuthsucess(task.getResult().getUser());
            }
                else {
                Toast.makeText(MainActivity.this, "Sign in Failed", Toast.LENGTH_SHORT).show();
            }
            }

        });
    }


    private void onAuthsucess(FirebaseUser user){
        String Username = usernameFromEmail(user.getEmail());
        writeNewUser(user.getUid(),Username,user.getEmail());
        startActivity(new Intent(this,Messenger.class));
        finish();
    }

    private void writeNewUser(String userId,String name, String email){
        User muser = new User(name,email);
        mDatabaseReference.child("total_user").child("id : "+ userId).setValue(muser);

    }

    private String usernameFromEmail(String email){
        if(email.contains("@")){
            return email.split("@")[0];
        }
        else {
            return email;
        }
    }

    private void hideProgressdialog(){
        if(mProgressDialog != null && mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }

    }

    private void showDailogbox() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Loading...");

        }
        mProgressDialog.show();
    }

    private boolean validForm() {
        boolean result = true;

        if (TextUtils.isEmpty(mEmail.getText().toString())) {
            mEmail.setError("REquired");
            result = false;
        } else {
            mEmail.setError(null);

        }
        if (TextUtils.isEmpty(mPassword.getText().toString())) {
            mPassword.setError("Required");
            result = false;
        } else {
            mPassword.setError(null);

        }

        return result;

    }


    private void signUp() {
        if(!validForm()){
            return;
        }
        showDailogbox();
        String getEmail = mEmail.getText().toString();
        String getPassword = mPassword.getText().toString();

        mFirebaseAuth.createUserWithEmailAndPassword(getEmail,getPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                hideProgressdialog();
                if(task.isSuccessful()){
                    onAuthsucess(task.getResult().getUser());
                }
                else {
                    Toast.makeText(MainActivity.this, "sing uP Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public String mgetUid(){
        return  FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

}
