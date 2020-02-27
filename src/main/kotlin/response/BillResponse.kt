package response

import com.fasterxml.jackson.annotation.JsonProperty

class BillResponse (
    @JsonProperty("id")
    var id:Int,
    @JsonProperty("amt")
    var amt:Int,
    @JsonProperty("ownedBy")
    var ownedBy:UserResponse,
    @JsonProperty("description")
    var description:String,
    @JsonProperty("ownedTo")
    var ownedTo: MutableList<UserResponse> = mutableListOf<UserResponse>()
){
}