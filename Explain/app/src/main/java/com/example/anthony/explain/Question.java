package com.example.anthony.explain;

import com.example.anthony.explain.User;

import java.util.ArrayList;

/**
 * Created by Anthony on 8/8/2015.
 */
public class Question {

    private String qText;
    private String qDesc;
    private User qUser;
    private ArrayList<Answer> answers;

    public Question(String qText, User qUser){
        this.qText = qText;
        this.qUser = qUser;
        this.qDesc = "";
        this.answers = new ArrayList<Answer>();
    }

    public Question(String qText, User qUser, String qDesc){
        this.qText = qText;
        this.qUser = qUser;
        this.qDesc = qDesc;
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

    public String getqDesc(){
        return qDesc;
    }

    public void setqDesc(String text){
        qDesc = text;
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
    }
}
