package services

import models.Bill
import models.Users
import services.UsersService

class BillService() {
    private var bills = mutableListOf<Bill>()

    private fun getID(): Int {
        return (bills.size + 1)
    }

    fun addBill(id:Int, amt:Int, giver: String, taker:String, users: UsersService): UsersService {
        var  currentBill = Bill(getID(), amt, giver, taker)
        users.updateBalance(giver,amt/2)
//        users.updateGiver(giver,taker,amt/2)
        users.updateBalance(taker,(-1*amt)/2)
        bills.add(currentBill)
        return users
    }

    fun addB(bill: Bill, users: UsersService):String{
        var x=addBill(bill.id, bill.amt, bill.ownedBy, bill.ownedTo, users)
        print(x)
        return "added"
    }

    fun showAllBills(): Any{
        return bills
    }
}
