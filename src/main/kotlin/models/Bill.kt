package models



data class Bill(val id:Int, val amt:Int, val ownedBy:Users, val ownedTo:Users)