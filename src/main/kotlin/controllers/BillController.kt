package controllers

import requests.BillRequest
import services.BillService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/bill")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class BillController(private var bills:BillService){

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
        return bills.settleBill(id)!!
    }
}