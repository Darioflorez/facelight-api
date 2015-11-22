package com.lab.serverdevelopment;

import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Dario on 2015-11-22.
 */

@Path("/login")
public class Login {

    @GET
    @Produces("application/json")
    public Response getMessage() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","dario");
        jsonObject.put("email","dario@email.com");

        String result = "" + jsonObject;
        return Response.status(200).entity(result).build();
    }

    @Path("{id}")
    @GET
    @Produces("application/json")
    public Response getUser(@PathParam("id") int id){

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", id);
        jsonObject.put("name", "dario");
        jsonObject.put("email", "dario@email.com");

        String result = "" + jsonObject;
        return Response.status(200).entity(result).build();
    }
}