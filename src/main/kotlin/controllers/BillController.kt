package controllers

import requests.BillRequest
import services.BillService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/bill")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class BillController(private var bills:BillService){
//    var users = UsersService()
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun addBill(billRequest: BillRequest) : String {
        print(billRequest)
        return bills.addBill(billRequest)
    }

    @GET
    fun getBills(): Any{
        return bills.showAllBills()
    }

    @POST
    @Path("/settle")
    fun settleBill(@QueryParam("id") id:Int): Any {
        var newUsers= bills.settleBill(id)!!
        if(newUsers=="No such bill exist")
            return "No such bill exist"
        if(newUsers=="Bill Already settled")
            return newUsers
//        users=(newUsers as UsersService)
        return "Bill settled"
    }
}