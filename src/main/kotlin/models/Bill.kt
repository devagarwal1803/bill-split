package models
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import io.ebean.Model
import javax.persistence.*

@Entity
class Bill(
    @Id
    @JsonProperty("id")
    var id:Int,
    @JsonProperty("amt")
    var amt:Int,
    @ManyToOne
    @JsonProperty("ownedBy")
    var ownedBy:Users,
    @JsonProperty("description")
    var description:String,
    @JsonProperty("ownedTo")
    @OneToMany(mappedBy = "bill")
    var ownedTo: MutableList<UserBill> = mutableListOf<UserBill>()
): Model(){
    @JsonIgnore
    var isSettled:Boolean=false
}