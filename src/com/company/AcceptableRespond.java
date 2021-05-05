package com.company;

public class AcceptableRespond extends Exception{
    @Override
    public String getMessage(){
        return "The input should be either yes or no";
    }
}
