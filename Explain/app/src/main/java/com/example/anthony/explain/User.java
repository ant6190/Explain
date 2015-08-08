package com.example.anthony.explain;

/**
 * Created by Anthony on 8/8/2015.
 */
public class User {

    private String userName;

    public User(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String user){
        this.userName = user;
    }
}
