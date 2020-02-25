package services

import com.fasterxml.jackson.annotation.JsonProperty
import models.Users

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

    fun addUser(user: Users):String {
        if(!checkUserWithExistingEmail(user.email)) {
            user.id=getID()
            users.add(user)
            return "User successfully created"
        }
        return  "User with email ${user.email} already exists"
    }

    fun updateUser(newUser: Users):String {
        for (user in users)
        {
            if(user.id==newUser.id)
            {
                user.email=newUser.email
                user.name=newUser.name
                user.number=newUser.number
//                return users
                return "User updated successfully"
            }
        }
        return "User with id ${newUser.id} does not exist"
    }

    fun showAllUsers(): Any {
        return users
    }

    fun getUserByEmail(email: String): Users? {
        for (user in users) {
            if (user.email == email)
                return user
        }
        return null
    }

    fun updateBalance(id: Int, amount:Int):String {
        for(i in users)
            if(i.id==id) {
                i.balance = (i.balance.plus(amount))
                return "Balance updated"
            }
        return "Unable to update balance"
    }

//    fun updateGiver(giver: String, taker: String,amount: Int)
//    {
//        user1.givers[user2] = user1.givers[user2]?.plus(amount)
//        user2.takers[user1] = user2.takers[user1]?.plus(amount)
//    }

}
