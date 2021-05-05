package com.company;

public class RightAnswer extends Exception{

    @Override
    public String getMessage(){
        return "The input should be a String";
    }
}
