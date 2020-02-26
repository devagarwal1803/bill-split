package models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import io.ebean.Model
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Users(
    @Id
    @JsonProperty("id")
    var id: Int,
    @JsonProperty("name")
    var name: String,
    @JsonProperty("email")
    var email: String,
    @JsonProperty("number")
    var number: Long = 0
) : Model()
{
    @JsonProperty("balance")
    var balance:Int = 0
    @JsonIgnore
    @OneToMany(cascade = [CascadeType.ALL])
    var  billList: List<Bill> = mutableListOf()
//    @JsonIgnore
//    var givers = mutableMapOf<Users,Int?>()
//    @JsonIgnore
//    var takers = mutableMapOf<Users,Int?>()
}