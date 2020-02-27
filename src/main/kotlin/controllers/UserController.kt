package controllers

import models.Users
import services.UsersService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class UserController(private val users: UsersService){

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun addUser(user: Users) : Response {
        print(user)
        return try {
            responseEntity(users.addUser(user),200)
        } catch (e: Exception){
            responseEntity( e.message!!, 400)
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateUser(user: Users) : Response {
        print(user)
        return try {
            responseEntity(users.updateUser(user),200)
        } catch (e: Exception){
            responseEntity( e.message!!, 400)
        }
    }

    @GET
    fun getUsers(): Any{
        return users.showAllUsers()
    }

    private fun responseEntity(message:Any, code:Int): Response {
        return Response.status(code).entity(message).build()
    }

}