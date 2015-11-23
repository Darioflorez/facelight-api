package com.lab.serverdevelopment.ViewModels;

/**
 * Created by dario on 2015-11-11.
 */
public class UserViewModel {

    private String firstName;
    private String lastName;

    private Long id;

    public UserViewModel(){
    }

    public UserViewModel(Long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName(){
        return firstName + " " + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
