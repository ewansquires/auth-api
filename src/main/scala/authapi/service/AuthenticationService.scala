package authapi.service

import authapi.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import play.api.libs.json.{JsNumber, JsObject, JsString, Json}

@Service
class AuthenticationService @Autowired()(private val jwtService: JwtService, private val userService: UserService) {

  def authenticate(user: User): String = {
    if (isRequesterAuthentic(user)) {
      jwtService.createToken(user)
    } else {
      "\"message\":\"Access Denied.\""
    }
  }

  def isAdmin(token: String): Boolean = isRole("Admin", token)

  private def isRole(role: String, token: String): Boolean = {
    val payload = Json.parse(jwtService.getMessageFromToken(token))
    val tokenRole = (payload \ "role").get.toString().replace("\"", "")
    tokenRole.equals(role)
  }

  private def isRequesterAuthentic(user: User) = ! (userService.findUser(user.getId()).get().getRole() == "Banned")
}
