package com.makeev.alfabank.exp;

public class NotValidInputException extends Exception{
    private String name;

    public NotValidInputException(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "NotValidInputException{" +
                "name='" + name + '\'' +
                '}';
    }
}
