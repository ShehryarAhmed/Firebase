package com.example.sayla.chatapp;

/**
 * Created by sayla on 04/12/2016.
 */
public class User {

    private String name;
    private String email;


    public User(){}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
