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
        val users= QUsers().findList()
        val bill = Bill(id=billDao.getID(),amt = billRequest.amt,description = billRequest.description,ownedBy = users[billRequest.ownedBy-1])
        val amtSplit=billRequest.amt/(billRequest.ownedTo.size+1)
        users[billRequest.ownedBy -1].balance+=(billRequest.amt-amtSplit)
        users[billRequest.ownedBy -1].update()
        for(id in billRequest.ownedTo) {
            val userBill=UserBill(bill = bill, users = users[id - 1])
            bill.ownedTo.add(userBill)
            users[id - 1].balance-=amtSplit
            users[id - 1].update()
        }
        print(bill)
        billDao.addBill(bill)
        for(id in billRequest.ownedTo){
            val userBill=UserBill(bill = bill, users = users[id - 1])
            userBill.save()
        }
        return "Bill added successfully"
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
        for(bill in QBill().findList()){
            if(bill.id==id)
            {
                if(bill.isSettled)
                    return "Bill Already settled"
                val amtSplit=bill.amt/(bill.ownedTo.size+1)
                var ownedTo= bill.ownedTo

                //Setting up for borrowers
                for(eachUser in ownedTo){
                    eachUser.users.balance+=amtSplit
                    eachUser.users.update()
                }

                //Setting up for payer
                    bill.ownedBy.balance+=(amtSplit-bill.amt)
                    bill.ownedBy.update()
                return "Bill Settled"
            }
        }
        return "No such bill exist"
    }
}
