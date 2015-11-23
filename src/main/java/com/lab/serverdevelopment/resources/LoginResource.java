package com.lab.serverdevelopment.resources;

import com.lab.serverdevelopment.ViewModels.UserViewModel;
import com.lab.serverdevelopment.forms.LoginForm;
import com.lab.serverdevelopment.handlers.UserHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Dario on 2015-11-22.
 */

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {

    @POST
    public UserViewModel authenticateUser(LoginForm userAuthenticationData) {
        return UserHandler.authenticateUser(userAuthenticationData);
    }

}