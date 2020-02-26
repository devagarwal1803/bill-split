package controllers

import io.ebean.DB
import io.ebeaninternal.server.type.ScalarTypeJsonMapPostgres
import models.Users
import services.UsersService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class UserController{
    var users = UsersService()

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

//    @QueryParam("email") email: String=""


    private fun responseEntity(message:Any, code:Int): Response {
        return Response.status(code).entity(message).build()
    }

//    @Path("/bill")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    fun addBill(bill: Bill) : String {
//        print(bill)
//        return bills.addB(bill, users)
//    }
//
//    @Path("/bill")
//    @GET
//    fun getBills(): Any{
//        return bills.showAllBills()
//    }
//
//    @Path("/bill/settle")
//    @POST
//    fun settleBill(@QueryParam("id") id:Int): Any {
//        var newUsers= bills.settleBill(id,users)!!
//        print("Hello")
//        if(newUsers=="No such bill exist")
//            return "No such bill exist"
//        if(newUsers=="Bill Already settled")
//            return newUsers
//        users=(newUsers as UsersService)
//        return "Bill Settled"
//    }
}