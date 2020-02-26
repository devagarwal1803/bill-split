package models
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import io.ebean.Model
import javax.persistence.*

@Entity
class Bill(
    @Id
    @Column(name = "bills_id")
    @JsonProperty("id")
    val id:Int,
    @JsonProperty("amt")
    val amt:Int,
    @JsonProperty("ownedBy")
    val ownedBy:Users,
    @JsonProperty("description")
    val description:String,
    @JsonProperty("ownedTo")
    @OneToMany(cascade = [CascadeType.ALL])
    val ownedTo:List<Users> = mutableListOf<Users>()
): Model(){
    @JsonIgnore
    var isSettled:Boolean=false
}