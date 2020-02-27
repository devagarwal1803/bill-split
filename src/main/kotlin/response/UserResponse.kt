package response

import com.fasterxml.jackson.annotation.JsonProperty

class UserResponse(
    @JsonProperty("id")
   var id: Int,
   @JsonProperty("name")
   var name: String,
   @JsonProperty("email")
   var email: String,
   @JsonProperty("number")
   var number: Long = 0){
}