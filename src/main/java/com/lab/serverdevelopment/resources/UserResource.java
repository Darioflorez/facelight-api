package com.lab.serverdevelopment.resources;

import com.lab.serverdevelopment.ViewModels.UserViewModel;
import com.lab.serverdevelopment.forms.UserForm;
import com.lab.serverdevelopment.handlers.UserHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Dario on 2015-11-22.
 */

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    public List<UserViewModel> getUsers(@QueryParam("name") String name){
        if(name != null){
            return UserHandler.getUserByName(name);
        }
        return UserHandler.getAllUsers();
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
    public UserViewModel updateUser(@PathParam("id") Long id, UserViewModel user){
        return user;
    }

    @DELETE
    @Path("{id}")
    public void deleteUser(@PathParam("id") Long id){
        System.out.println("Message deleted!");
    }





}
