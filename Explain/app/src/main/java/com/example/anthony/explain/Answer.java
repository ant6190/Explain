package com.example.anthony.explain;

import com.example.anthony.explain.User;

/**
 * Created by Anthony on 8/8/2015.
 */
public class Answer {

    private User aUser;
    private String aText;

    private Answer(User aUser, String aText){
        this.aUser = aUser;
        this.aText = aText;
    }

    public User getaUser(){
        return aUser;
    }

    public void setaUser(User user){
        aUser = user;
    }

    public String getaText(){
        return aText;
    }

    public void setaText(String text){
        aText = text;
    }

}
