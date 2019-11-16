//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

public class User{
    private String userName;
    private String password;
    /* Cart object has a userName reference so each user 
       technically will have a cart.
    */
    
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    public void setUserName(String username){
        this.userName = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getUserName(){
        return this.userName;
    }
    public String getPassword(){
        return this.password;
    }
}