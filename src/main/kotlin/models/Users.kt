package models



data class Users(val id: Int, var name: String, val email: String, var number: Number, var balance:Int?=0){
    var givers = mutableMapOf<Users,Int?>()
    var takers = mutableMapOf<Users,Int?>()

}