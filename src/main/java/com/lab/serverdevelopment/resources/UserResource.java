package com.lab.serverdevelopment.resources;

import com.lab.serverdevelopment.ViewModels.UserViewModel;
import com.lab.serverdevelopment.forms.UserForm;
import com.lab.serverdevelopment.handlers.UserHandler;
import com.lab.serverdevelopment.models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dario on 2015-11-22.
 */

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    public List<User> getUsers(){
        User u1 = new User ();
        u1.setFirstName("dario");
        User u2 = new User();
        u2.setFirstName("andres");
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);

        return list;
    }

    @GET
    @Path("{id}")
    public UserViewModel getUser(@PathParam("id") Long id){
        return UserHandler.find(id);
    }

    @POST
    public UserViewModel registerUser(UserForm user){
        return UserHandler.createUser(user);
    }

    @PUT
    @Path("{id}")
    public User updateUser(@PathParam("id") Long id, User user){

        return user;
    }

    @DELETE
    @Path("{id}")
    public void deleteUser(@PathParam("id") Long id){
        System.out.println("Message deleted!");
    }




}
