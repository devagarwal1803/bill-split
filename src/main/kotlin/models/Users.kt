package models

import com.fasterxml.jackson.annotation.*

data class Users(
    @JsonProperty("id")
    var id: Int,
    @JsonProperty("name")
    var name: String,
    @JsonProperty("email")
    var email: String,
    @JsonProperty("number")
    var number: Long = 0
)
{
    @JsonProperty("balance")
    var balance:Int = 0
    @JsonIgnore
    var givers = mutableMapOf<Users,Int?>()
    @JsonIgnore
    var takers = mutableMapOf<Users,Int?>()
}