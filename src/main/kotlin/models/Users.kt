package models

import com.fasterxml.jackson.annotation.*
import io.ebean.Model
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Users(
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
//    @JsonIgnore
//    var givers = mutableMapOf<Users,Int?>()
//    @JsonIgnore
//    var takers = mutableMapOf<Users,Int?>()
}