import services.BillService

fun main() {
    var bills= BillService()
    while(true)
    {
        println("Select an option to operate upon:\n 1. Users\n 2. Bills\n 3. Groups")
        var option = readLine()!!
        if(option.toInt()==2)
        {
            println("Entered bills")
            println("Select an option to operate upon:\n 1. Add a new Bill\n 2. Show all Bills\n 3. Delete an Bill")
            option = readLine()!!
            when {
                option.toInt()==1 -> {
                    println("option 1-> Add new bill->selected")
                    print("Enter amount:")
                    var amount = readLine()!!
                    bills.addBill(bills.getID(),amount.toInt())
                }
                option.toInt()==2 -> {
                    println("option 2-> Show all bill->selected")
                    bills.showBill()
                }
                option.toInt()==3 -> {
                    println("option 3-> Delete bill->selected")
                }
                else -> {
                    println("Kindly select and valid option")
                }
            }
        }
    }
}