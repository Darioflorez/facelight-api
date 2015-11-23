package com.lab.serverdevelopment.handlers;


import com.lab.serverdevelopment.ViewModels.UserViewModel;
import com.lab.serverdevelopment.dao.UserDAO;
import com.lab.serverdevelopment.forms.LoginForm;
import com.lab.serverdevelopment.forms.UserForm;
import com.lab.serverdevelopment.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dario on 2015-11-09.
 */
public class UserHandler {

    private static UserDAO userDAO = new UserDAO();

    public static UserViewModel authenticateUser(LoginForm userAuthenticationData){
        if(userAuthenticationData.getEmail().equals(null) || userAuthenticationData.getPassword().equals(null)){
            return null;
        }
        UserViewModel userViewModel = new UserViewModel();
        User user = userDAO.authenticateUser(userAuthenticationData.getEmail(),
                userAuthenticationData.getPassword());
        if(user != null){
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
    public static List<UserViewModel>getUserByName(String query){
        List<User> users = userDAO.listUserByName(query);
        return usersToUserViewModelList(users);
    }

    public static List<UserViewModel> getAllUsers(){
        List<User> users = userDAO.listUsers();
        return usersToUserViewModelList(users);
    }

    public static UserViewModel find(Long id){
        User user = userDAO.find(id);
        return new UserViewModel(user.getId(), user.getFirstName(), user.getLastName());
    }

    private static List<UserViewModel> usersToUserViewModelList(List<User> users){
        ArrayList<UserViewModel> usersModelView = new ArrayList<>();
        users.forEach(m -> usersModelView.add(
                new UserViewModel(m.getId(), m.getFirstName(), m.getLastName())));
        return usersModelView;
    }
}
