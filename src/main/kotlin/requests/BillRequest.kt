package requests
import com.fasterxml.jackson.annotation.JsonProperty

class BillRequest(
    @JsonProperty("amt")
    var amt:Int,
    @JsonProperty("ownedBy")
    var ownedBy:Int,
    @JsonProperty("description")
    var description:String,
    @JsonProperty("ownedTo")
    val ownedTo: MutableList<Int> = mutableListOf<Int>()
)