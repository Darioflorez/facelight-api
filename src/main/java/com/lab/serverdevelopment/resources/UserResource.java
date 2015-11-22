package com.lab.serverdevelopment.resources;

import com.lab.serverdevelopment.models.User;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Dario on 2015-11-22.
 */

@Path("/users")
public class UserResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
        //Return all users
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("users", "return a list of users");

        String result = "" + jsonObject;

        return Response.status(200).entity(result).build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") Long id){

        User user = new User(id, "dario");

        return user;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", "user registered success!");

        String result = "" + jsonObject;

        return Response.status(201).entity(result).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", "user updated!");

        String result = "" + jsonObject;

        return Response.status(200).entity(result).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", "user deleted!");

        String result = "" + jsonObject;

        return Response.status(204).entity(result).build();
    }




}
