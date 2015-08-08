package com.example.anthony.explain;

/**
 * Created by Anthony on 8/8/2015.
 */
public class User {

    private String userName;
    private String password;

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String user){
        this.userName = user;
    }

    public String getPassword() {
        return password;
    }
}
