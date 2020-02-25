package controllers

import models.Bill
import models.Users
import services.BillService
import services.UsersService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class UserController{
    var users = UsersService()
    var bills = BillService()

    @Path("/user")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun addUser(user: Users) : String {
        print(user)
        return users.addUser(user)
    }

    @Path("/user")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateUser(user: Users) : String {
        print(user)
        return users.updateUser(user)
    }

    @Path("/user")
    @GET
    fun getUsers(): Any{
        return users.showAllUsers()
    }


    @Path("/bill")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun addBill(bill: Bill) : String {
        print(bill)
        return bills.addB(bill, users)
    }

    @Path("/bill")
    @GET
    fun getBills(): Any{
        return bills.showAllBills()
    }
}