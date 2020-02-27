package models

import io.ebean.Model
import javax.persistence.*

@Entity
class UserBill(
//    @Idd,
    @ManyToOne
    val bill: Bill,
    @ManyToOne
    val users: Users
): Model(){

}