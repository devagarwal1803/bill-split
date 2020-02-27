package controllers;

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType


@Path("/monetSplit")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class UserOwesController {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    fun getAllMoney() : Any
    {
        return "Hello"
    }

}