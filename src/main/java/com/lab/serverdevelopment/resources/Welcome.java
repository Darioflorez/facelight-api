package com.lab.serverdevelopment.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Dario on 2015-11-22.
 */

@Path("/")
public class Welcome {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {

        return "Welcome to facelight API!";
    }
}
