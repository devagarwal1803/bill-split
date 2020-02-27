package dao

import io.ebean.Database
import models.Bill
import models.UserBill
import models.query.QBill
import models.query.QUsers
import requests.BillRequest

class BillDao(var database: Database) {
    fun getID(): Int {
        return (QBill().findCount() + 1)
    }


    fun addBill(billRequest: BillRequest):String{
        val users= QUsers().findList()
        val bill = Bill(id=getID(),amt = billRequest.amt,description = billRequest.description,ownedBy = users[billRequest.ownedBy-1])
        val amtSplit=billRequest.amt/(billRequest.ownedTo.size+1)
        users[billRequest.ownedBy -1].balance+=(billRequest.amt-amtSplit)
        users[billRequest.ownedBy -1].update()
        for(id in billRequest.ownedTo) {
            val userBill= UserBill(bill = bill, users = users[id - 1])
            bill.ownedTo.add(userBill)
            users[id - 1].balance-=amtSplit
            users[id - 1].update()
        }
        print(bill)
        bill.save()
        for(id in billRequest.ownedTo){
            val userBill= UserBill(bill = bill, users = users[id - 1])
            userBill.save()
        }
        return "Bill added successfully"
    }

    fun showAllBills(): Any{
        return QBill().findList()
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

                bill.isSettled=true
                bill.update()
                return "Bill Settled"
            }
        }
        return "No such bill exist"
    }
}
