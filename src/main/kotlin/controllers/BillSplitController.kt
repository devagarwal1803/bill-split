package controllers

import io.dropwizard.Configuration
import services.BillService
import services.UsersService
import javax.ws.rs.*

@Path("/")
class BillSplitController{
    var users = UsersService()
    var bills = BillService()

    @Path("/test")
    @GET
    fun multiply(@QueryParam("name") name: String): String {
        return "Hello $name"
    }

    @Path("/users/add")
    @POST
    fun addUser(@QueryParam("name") name: String, @QueryParam("email") email: String, @QueryParam("number") number: String): String {
        users.addUser(name, email, number.toInt())
        return "User added"
    }

    @Path("/users")
    @GET
    fun listUsers(): String{
        return users.showAllUsers()
    }
}