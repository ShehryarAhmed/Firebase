package com.example.sayla.firebase;

/**
 * Created by sayla on 04/12/2016.
 */
public class User {

    public User(){

    }

    private String mfirst_name;

    private String mlast_name;

    public String getMfirst_name() {
        return mfirst_name;
    }

    public String getMlast_name() {
        return mlast_name;
    }

    public User(String mfirst_name, String mlast_name) {

        this.mfirst_name = mfirst_name;
        this.mlast_name = mlast_name;
    }



}

