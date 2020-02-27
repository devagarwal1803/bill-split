package dao
import io.ebean.Database
import models.Users
import models.query.QUsers

open class UsersDao(var database:Database) {

    fun getID(): Int {
        return (QUsers().findCount() + 1)
    }


    //This can be optimised by query
    fun checkUserWithExistingEmail(email: String): Boolean {
        for (user in QUsers().findList())
        {
            if(user.email==email)
                return true
        }
        return false
    }

    fun addUser(user: Users):String {
        user.id=getID()
        user.balance=0
        user.save()
        return "User successfully created with id ${user.id}"
    }

    fun updateUser(newUser: Users):String {
        newUser.update()
        return "User Updated Successfully"
     }

    fun showAllUsers(): Any {
        return QUsers().findList()
    }

    //This can be optimised by query
    fun getUserByEmail(email: String): Users? {
        for (user in QUsers().findList()) {
            if (user.email == email)
                return user
        }
        return null
    }

    //This can be optimised by query
    fun getUserById(id: Int): Users? {
        for (user in QUsers().findList()) {
            if (user.id == id)
                return user
        }
        return null
    }

    //This can be optimised by query
    fun updateBalance(id: Int, amount:Int):String {
        for(user in QUsers().findList())
            if(user.id==id) {
                user.balance = (user.balance.plus(amount))
                user.update()
                return "Balance updated"
            }
        return "Unable to update balance"
    }

}
