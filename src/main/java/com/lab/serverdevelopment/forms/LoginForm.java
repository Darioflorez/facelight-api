package com.lab.serverdevelopment.forms;

import java.io.Serializable;

/**
 * Created by johan on 09/11/15.
 */
public class LoginForm implements Serializable {

    private String email;
    private String password;

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

}
