package controllers

import models.Bill
import models.Users
import services.BillService
import services.UsersService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/bill")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class BillController{
//    var bills = BillService()
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    fun addBill(bill: Bill) : String {
//        print(bill)
//        return bills.add(bill)
//    }
//
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    fun updateBill(user: Users) : String {
//        print(user)
//        return bills.updateUser(user)
//    }
//
//
//    @GET
//    fun getBills(): Any{
//        return bills.showAllUsers()
//    }
}