package models
import com.fasterxml.jackson.annotation.*


data class Bill(
    @JsonProperty("id")
    val id:Int,
    @JsonProperty("amt")
    val amt:Int,
    @JsonProperty("ownedBy")
    val ownedBy:Any = mutableListOf<Int>(),
    @JsonProperty("ownedTo")
    val ownedTo:Any = mutableListOf<Int>()
)