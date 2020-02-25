package models
import com.fasterxml.jackson.annotation.*


data class Bill(
    @JsonProperty("id")
    val id:Int,
    @JsonProperty("amt")
    val amt:Int,
    @JsonProperty("ownedBy")
    val ownedBy:String,
    @JsonProperty("ownedTo")
    val ownedTo:String
)