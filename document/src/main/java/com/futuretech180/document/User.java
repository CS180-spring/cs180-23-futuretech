package com.futuretech180.document;

public class User {
    private String name;
    // private int userID;
    private String password;

    public String getName(){
        return name;
    }
    // public int getUserID(){
    //     return userID;
    // }
    public String getPassword(){
        return password;
    }

    public void setName(String newName){
        this.name = newName;
    }
    // public void setUserID(int newID){
    //     this.userID = newID;
    // }
    public void setPassword(String pass){
        this.password = pass;
    }
}