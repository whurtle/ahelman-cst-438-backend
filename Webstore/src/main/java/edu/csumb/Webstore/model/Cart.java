//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

import java.util.HashMap;

public class Cart {
    private String userName;
    private HashMap<String, Integer> products;
    
    public Cart(String userName, HashMap<String, Integer> products){
        this.userName = userName;
        this.products = products;
    }
    public String getUserName(){
        return this.userName;
    }
    public HashMap<String, Integer> getProducts(){
        return this.products;
    }
    public void setUserName(String username){
        this.userName = username;
    }
    public void setProducts(HashMap<String,Integer> products){
        this.products = products;
    }
}