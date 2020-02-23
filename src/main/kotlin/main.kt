import services.BillService
import services.UsersService

fun main() {
    var users = UsersService()
    var bills = BillService()

    while(true)
    {
        println("Select an option to operate upon:\n 1. Users\n 2. Bills\n 3. Groups")
        var option = readLine()!!
        if(option.toInt()==1)
        {
            println("Entered users")
            println("Select an option to operate upon:\n 1. Add new user\n 2.Update users\n 3. List all users\n")
            option = readLine()!!
            when {
                option.toInt()==1 -> {
                    println("option 1-> Add new user->selected")
                    print("Enter name:")
                    var name = readLine()!!
                    print("Enter email:")
                    var email = readLine()!!
                    print("Enter Phone number:")
                    var number = readLine()!!
                    users.addUser(name, email, number.toInt())
                }
                option.toInt()==2 -> {
                    println("option 2-> Update users->selected")
                    println("1. Update name\n2. Update number")
                    option= readLine()!!
                    print("Enter email:")
                    var email = readLine()!!
                    when {
                        option.toInt() == 1 -> {
                            print("Enter name:")
                            var name = readLine()!!
                            users.updateUser(email, name)
                        }
                        option.toInt() == 2 -> {
                            print("Enter Phone number:")
                            var number = readLine()!!
                            users.updateUser(email, number.toInt())
                        }
                        else -> println("Wrong option")
                    }
                }
                option.toInt()==3 -> {
                    println("option 3-> Show all users->selected")
                    users.showAllUsers()
                }
                else -> {
                    println("Kindly select and valid option")
                }
            }

        }
        else if(option.toInt()==2)
        {
            println("Entered bills")
            println("Select an option to operate upon:\n 1. Add new Bill\n 2. Show all Bills\n")
            option = readLine()!!
            when {
                option.toInt()==1 -> {
                    println("option 1-> Add new bill->selected")
                    print("Enter amount:")
                    var amount = readLine()!!
                    print("Paid by:")
                    var paid_by = readLine()!!
                    print("Paid for:")
                    var paid_to = readLine()!!
                    var giver=users.getUserByEmail(paid_by)!!
                    var taker=users.getUserByEmail(paid_to)!!
                    users = bills.addBill(bills.getID(), amount.toInt(), giver, taker, users)
                }
                option.toInt()==2 -> {
                    println("option 2-> Show all bill->selected")
                    bills.showBill()
                }
                else -> {
                    println("Kindly select and valid option")
                }
            }
        }
    }
}