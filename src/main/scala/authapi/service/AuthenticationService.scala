package authapi.service

import authapi.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import play.api.libs.json.{JsObject, JsString, Json}

@Service
class AuthenticationService @Autowired()(private val jwtService: JwtService, private val userService: UserService) {

  def authenticate(user: User): String = {
    if (isRequesterAuthentic(user)) {
      jwtService.createToken(user)
    } else {
      generateJsonMessage("Access Denied.")
    }
  }

  private def isRequesterAuthentic(user: User) = ! (userService.findUser(user.getId()).get().getRole() == "Banned")

  private def generateJsonMessage(message: String) = {
    Json.stringify(
      JsObject(
        Seq(
          "message" -> JsString(message)
        )
      )
    )
  }
}
