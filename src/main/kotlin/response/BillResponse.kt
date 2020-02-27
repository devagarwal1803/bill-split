package response

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import models.UserBill
import models.Users

class BillResponse (
    @JsonProperty("id")
    var id:Int,
    @JsonProperty("amt")
    var amt:Int,
    @JsonProperty("ownedBy")
    var ownedBy:Users,
    @JsonProperty("description")
    var description:String,
    @JsonProperty("ownedTo")
//    @JsonIgnore
    var ownedTo: MutableList<UserResponse> = mutableListOf<UserResponse>()
){
}