package models
import com.fasterxml.jackson.annotation.*
import io.ebean.annotation.WhenCreated
import org.joda.time.DateTime
import java.util.*
import javax.persistence.Id


data class Bill(
    @Id
    @JsonProperty("id")
    val id:Int,
    @JsonProperty("amt")
    val amt:Int,
    @JsonProperty("ownedBy")
    val ownedBy:Any = mutableListOf<Int>(),
    @JsonProperty("ownedTo")
    val ownedTo:Any = mutableListOf<Int>()
){
    @JsonIgnore
    var isSettled:Boolean=false,
    @WhenCreated Timestamp creationTime
}