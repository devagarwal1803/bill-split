package services

import models.Users
import javax.jws.soap.SOAPBinding

class UsersService() {
    private var users = mutableListOf<Users>()

    private fun getID(): Int {
        return (users.size + 1)
    }

    private fun checkUserWithExistingEmail(email: String): Boolean {
        for (user in users)
        {
            if(user.email==email)
                return true
        }
        return false
    }

    fun addUser(name: String, email: String, number: Number){
        if(!checkUserWithExistingEmail(email)) {
            val user = Users(this.getID(), name, email, number)
            users.add(user)
        }
    }

    fun updateUser(email: String, name: String)
    {
        for (user in users)
        {
            if(user.email==email)
            {
                user.name=name
                return
            }
        }
        println("User with mail $email does not exist")
    }
    fun updateUser(email: String, number: Number)
    {
        for (user in users)
        {
            if(user.email==email)
            {
                user.number=number
            }
        }
    }

    fun showAllUsers(){
        if(users.size>0) {
            for (user in users) {
                println("User->${user.id} ${user.name} ${user.email} ${user.number} ${user.balance}")
                print("Gave->")
                for (x in user.givers)
                    println("${x.key} gave ${x.value}")
                print("Took->")
                for (x in user.takers)
                    println("${x.key} took ${x.value}")
                println("---------------Particular-User ended----------------\n")
            }
        }
        else
            println("No users create till now\n")
        println("----------------Users ended----------------\n\n")
    }

    fun getUserByEmail(email: String): Users? {
        for (user in users) {
            if (user.email == email)
                return user
        }
        return null
    }

    fun updateBalance(user:Users, amount:Int)
    {
        for(i in users)
            if(i.id==user.id)
                i.balance=(i.balance?.plus(amount))
    }

    fun updateGiver(user1: Users, user2: Users,amount: Int)
    {
        user1.givers[user2] = user1.givers[user2]?.plus(amount)
        user2.takers[user1] = user2.takers[user1]?.plus(amount)


    }

}
