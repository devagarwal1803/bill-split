package services

import dao.BillDao
import models.Bill
import models.UserBill
import models.Users
import models.query.QBill
import requests.BillRequest
import models.query.QUsers
import response.BillResponse
import response.UserResponse

class BillService(private var billDao:BillDao){

    fun addBill(billRequest: BillRequest):String{
        return billDao.addBill(billRequest)
    }

    fun showAllBills(): Any{
        var ans=billDao.showAllBills()
        var allBills = (ans as List<Bill>)
        var allBill:MutableList<BillResponse> =  mutableListOf<BillResponse>()
        for(eachBill in allBills){
            var ownedBy=eachBill.ownedBy
            var ownedTo: MutableList<UserResponse> = mutableListOf<UserResponse>()
            for(user in eachBill.ownedTo) {
                var userResponse=UserResponse(user.users.id, user.users.name, user.users.email, user.users.number)
                ownedTo.add(userResponse)
            }
            var ownedByUserResponse=UserResponse(ownedBy.id, ownedBy.name, ownedBy.email, ownedBy.number)
            allBill.add(BillResponse(eachBill.id, eachBill. amt, ownedByUserResponse, eachBill.description,ownedTo))
        }
        return allBill
    }


    fun settleBill(id:Int):Any{
        return billDao.settleBill(id)
    }
}
