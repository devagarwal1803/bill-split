package services

import models.Users
import org.eclipse.jetty.http.HttpStatus

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
            user.balance=0
            users.add(user)
            user.save()
            return "User successfully created with id ${user.id}"
        }
        return  "User with email ${user.email} already exists"
    }

    fun updateUser(newUser: Users):String {
        for (user in users)
        {
            if(user.id==newUser.id)
            {
                if(!checkUserWithExistingEmail(newUser.email)) {
                    user.email = newUser.email
                    user.name = newUser.name
                    user.number = newUser.number
                    newUser.update()
//                return users
//                user.save()
                    return "User updated successfully"
                }
                else
                    return "User with email ${newUser.email} already exist"
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

    fun getUserById(id: Int): Users? {
        for (user in users) {
            if (user.id == id)
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
