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
            users.add(user)
            return "User successfully created"
        }
        return  "User with email ${user.email} already exists"
    }

    fun updateUser(newUser: Users):String {
        for (user in users)
        {
            if(user.email==newUser.email)
            {
                user.name=newUser.name
                user.number=newUser.number
                return "User updated successfully"
            }
        }
        return "User with email ${newUser.email} does not exist"
    }

    fun showAllUsers(): Any {
        return users
////        var response = mutableMapOf<String,Any>()
//        if(users.size>0) {
//            for (user in users) {
////                var temp = mutableMapOf<String, Any>();
////                temp["id"] = user.id
////                temp["name"] = user.name
////                temp["phoneNumber"] = user.number
////                temp["balance"] = user.balance!!
//
//                println("User->${user.id} ${user.name} ${user.email} ${user.number} ${user.balance}")
//                print("Gave->")
//                for (x in user.givers)
//                    println("${x.key} gave ${x.value}")
//                print("Took->")
//                for (x in user.takers)
//                    println("${x.key} took ${x.value}")
////                response["data"].a
//            }
//            return users.size.toString()
//        }
//        return "No users create till now"
    }

    fun getUserByEmail(email: String): Users? {
        for (user in users) {
            if (user.email == email)
                return user
        }
        return null
    }

    fun updateBalance(email: String, amount:Int)
    {
        for(i in users)
            if(i.email==email)
                i.balance=(i.balance?.plus(amount))
    }

//    fun updateGiver(giver: String, taker: String,amount: Int)
//    {
//        user1.givers[user2] = user1.givers[user2]?.plus(amount)
//        user2.takers[user1] = user2.takers[user1]?.plus(amount)
//    }

}
