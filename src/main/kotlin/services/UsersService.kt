package services

import models.Users
import dao.UsersDao
import models.query.QUsers

class UsersService(private val userDao: UsersDao) {

    fun addUser(user: Users):String {
        if(!userDao.checkUserWithExistingEmail(user.email))
            return userDao.addUser(user)
        else
            throw Exception("User with email ${user.email} already exists")

    }

    fun updateUser(user: Users):String {
        if(!userDao.checkUserWithExistingEmail(user.email))
        {
            if(userDao.getID()>user.id)
                return userDao.updateUser(user)
            else
                throw Exception("No user exist with id=${user.id}")
        }
        else
            throw Exception("User with email ${user.email} already exists")
    }

    fun showAllUsers(): Any {
        return userDao.showAllUsers()
    }

    fun getUserByEmail(email: String): Users? {
        return userDao.getUserByEmail(email)
    }

    fun getUserById(id: Int): Users? {
        return userDao.getUserById(id)
    }

    fun updateBalance(id: Int, amount:Int):String {
        return updateBalance(id,amount)
    }

//    fun updateGiver(giver: String, taker: String,amount: Int)
//    {
//        user1.givers[user2] = user1.givers[user2]?.plus(amount)
//        user2.takers[user1] = user2.takers[user1]?.plus(amount)
//    }

}
