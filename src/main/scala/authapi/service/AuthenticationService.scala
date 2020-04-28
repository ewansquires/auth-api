package authapi.service

import authapi.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import play.api.libs.json.{JsNumber, JsObject, JsString, Json}

@Service
class AuthenticationService @Autowired()(private val jwtService: JwtService, private val userService: UserService) {

  def authenticate(user: User): String = {
    if (userService.isRequesterAuthentic(user)) {
      jwtService.createToken(user)
    } else {
      "\"message\":\"Access Denied.\""
    }
  }
}
