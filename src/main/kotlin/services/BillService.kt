package services

import dao.BillDao
import models.Bill
import models.UserBill
import requests.BillRequest
import models.query.QUsers

class BillService() {
    private var billDao = BillDao()


//    private fun addBill(id:Int, amt:Int, givers: List<Int>, takers:List<Int>, users: UsersService): UsersService {
//        var totalUsers= givers.size + takers.size
//        var splitAmt = amt/totalUsers
//        var currentBill = Bill(getID(), amt, givers, takers)
//        for (giver in givers)
//            users.updateBalance(giver,splitAmt)
////        users.updateGiver(giver,taker,amt/2)
//        for(taker in takers)
//            users.updateBalance(taker,(-1*splitAmt))
//        bills.add(currentBill)
//        bill.save()
//        print(users)
//        return users
//    }

    fun addBill(billRequest: BillRequest):String{
        val users= QUsers().findList()
        val bill = Bill(id=billDao.getID(),amt = billRequest.amt,description = billRequest.description,ownedBy = users[billRequest.ownedBy])
        for(id in billRequest.ownedTo) {
            val userBill=UserBill(bill = bill, users = users[id - 1])
            bill.ownedTo.add(userBill)
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
        return billDao.showAllBills()
    }

//    fun settleBill(id:Int, users: UsersService):Any{
//        for(bill in bills){
//            if(bill.id==id)
//            {
//                if(bill.isSettled==true)
//                    return "Bill Already settled"
//                var ownedBy = bill.ownedBy as List<Int>
//                var ownedTo= bill.ownedTo as List<Int>
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
//            }
//        }
//        return "No such bill exist"
//    }
}
