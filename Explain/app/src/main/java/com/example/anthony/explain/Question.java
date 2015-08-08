package com.example.anthony.explain;

import com.example.anthony.explain.User;

import java.util.ArrayList;

/**
 * Created by Anthony on 8/8/2015.
 */
public class Question {

    private String qText;
    private User qUser;
    private ArrayList<Answer> answers;

    public Question(String qText, User qUser){
        this.qText = qText;
        this.qUser = qUser;
        this.answers = new ArrayList<Answer>();
    }

    public String getqText(){
        return qText;
    }

    public void setqText(String text){
        qText = text;
    }

    public User getqUser(){
        return qUser;
    }

    public void setqUser(User user){
        qUser = user;
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
    }
}
