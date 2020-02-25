package services

import models.Bill

class BillService() {
    private var bills = mutableListOf<Bill>()

    private fun getID(): Int {
        return (bills.size + 1)
    }

    private fun addBill(id:Int, amt:Int, givers: List<Int>, takers:List<Int>, users: UsersService): UsersService {
        var totalUsers= givers.size + takers.size
        var splitAmt = amt/totalUsers
        var currentBill = Bill(getID(), amt, givers, takers)
        for (giver in givers)
            users.updateBalance(giver,splitAmt)
//        users.updateGiver(giver,taker,amt/2)
        for(taker in takers)
            users.updateBalance(taker,(-1*splitAmt))
        bills.add(currentBill)
        print(users)
        return users
    }

    fun addB(bill: Bill, users: UsersService):String{
        var x=addBill(bill.id, bill.amt, bill.ownedBy as List<Int>, bill.ownedTo as List<Int>, users)
        print(x)
        return "Bill added successfully"
    }

    fun showAllBills(): Any{
        return bills
    }
}
