package models

import io.ebean.Model
import javax.persistence.*

@Entity
class UserBill(
//    @Id
//    val id: Int,
    @ManyToOne
    val bill: Bill,
    @ManyToOne
    val users: Users
): Model(){

}