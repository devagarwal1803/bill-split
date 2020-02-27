package services

import dao.BillDao
import models.Bill
import models.UserBill
import models.query.QBill
import requests.BillRequest
import models.query.QUsers
import response.BillResponse
import response.UserResponse

class BillService() {
    private var billDao = BillDao()

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
            var ownedTo: MutableList<UserResponse> = mutableListOf<UserResponse>()
            for(user in eachBill.ownedTo) {
                var userResponse=UserResponse(user.users.id, user.users.name, user.users.email, user.users.number)
                ownedTo.add(userResponse)
            }
            println("Hello")
            allBill.add(BillResponse(eachBill.id, eachBill. amt, eachBill.ownedBy, eachBill.description,ownedTo))
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
                var ownedTo= bill.ownedTo as List<Int>
//
//                var totalUsers= ownedBy.size + ownedTo.size
//                var splitAmt = (bill.amt)/totalUsers
//
//                for (giver in ownedTo)
//                    users.updateBalance(giver,splitAmt)
//                for(taker in ownedBy)
//                    users.updateBalance(taker,(-1*splitAmt))
//                bill.isSettled=true
//                return users
                return "Figuring out"
            }
        }
        return "No such bill exist"
    }
}
