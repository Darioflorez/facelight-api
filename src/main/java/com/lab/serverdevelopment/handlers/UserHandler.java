package com.lab.serverdevelopment.handlers;


import com.lab.serverdevelopment.ViewModels.UserViewModel;
import com.lab.serverdevelopment.dao.UserDAO;
import com.lab.serverdevelopment.forms.UserForm;
import com.lab.serverdevelopment.models.User;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dario on 2015-11-09.
 */
public class UserHandler {

    private static UserDAO userDAO = new UserDAO();

    public static UserViewModel authenticateUser(String email, String password){
        if(email.equals(null) || password.equals(null)){
            return null;
        }
        UserViewModel userViewModel = new UserViewModel();
        User user = userDAO.authenticateUser(email,password);
        if(user != null){
            //create userBean
            userViewModel.setId(user.getId());
            userViewModel.setFirstName(user.getFirstName());
            userViewModel.setLastName(user.getLastName());

        }
        return userViewModel;
    }

    public static UserViewModel createUser(UserForm userForm){

        User user = new User();
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setPasswordConfirmation(userForm.getPasswordConfirmation());

        user = userDAO.create(user);
        UserViewModel createdUser = new UserViewModel(user.getId(), user.getFirstName(), user.getLastName());

        return createdUser;
    }

    //Return ArrayList<UseViewModel>
    public static ArrayList<UserViewModel>getUserByName(String query){
        //Fix here
        Collection<User> users = userDAO.listUserByName(query);
        ArrayList<UserViewModel> usersModelView = new ArrayList<>();
        users.forEach(m -> usersModelView.add(
                new UserViewModel(m.getId(), m.getFirstName(), m.getLastName())));

        return usersModelView;
    }

    public static UserViewModel find(Long id){
        User user = userDAO.find(id);
        return new UserViewModel(user.getId(), user.getFirstName(), user.getLastName());
    }

    public static Collection getAllUsers(){
        Collection<User> users = userDAO.listUsers();
        return users;
    }

}
