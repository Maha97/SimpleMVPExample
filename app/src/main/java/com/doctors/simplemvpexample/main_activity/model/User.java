package com.doctors.simplemvpexample.main_activity.model;

public class User {

    private String fullName = "", fruit = "";

    public User() {
    }

    public User(String fullName, String fruit) {
        this.fullName = fullName;
        this.fruit = fruit;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getfruit() {
        return fruit;
    }

    public void setfruit(String fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return "You Rock " + ""+fullName +"" +"\n You Like  : " +fruit +"\n  Great !" ;
    }
}
