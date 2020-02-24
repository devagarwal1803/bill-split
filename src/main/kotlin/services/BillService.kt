package services

import models.Bill
import models.Users

class BillService() {
    private var bills = mutableListOf<Bill>()

    fun getID(): Int {
        return (bills.size + 1)
    }

    fun addBill(id:Int, amt:Int, giver: Users, taker:Users, users: UsersService): UsersService {
        var  currentBill = Bill(id, amt, giver, taker)
        users.updateBalance(giver,amt/2)
        users.updateGiver(giver,taker,amt/2)
        users.updateBalance(taker,(-1*amt)/2)
        bills.add(currentBill)
        return users
    }

    fun showBill(){
        for (bill in bills){
            println("$bill ${bill.id} ${bill.amt}")
        }
        println("----------------Bills ended----------------")
    }
}
