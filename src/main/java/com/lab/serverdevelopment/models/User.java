package com.lab.serverdevelopment.models;

/**
 * Created by Dario on 2015-11-22.
 */
public class User {

    Long id;
    String name;

    public User(){

    }

    public User(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}