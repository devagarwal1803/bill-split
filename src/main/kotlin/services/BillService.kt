package services

import models.Bill

class BillService() {
    var bills = mutableListOf<Bill>()

    fun addBill(id:Int, amt:Int){
        var  currentBill = Bill(id, amt)
        bills.add(currentBill)
    }

    fun showBill(){
        for (bill in bills){
            println("$bill ${bill.id} ${bill.amt}")
        }
        println("----------------Bills ended----------------")
    }

    fun getID(): Int {
        return (bills.size + 1)
    }
}
