package authapi.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthenticationService @Autowired()(private val jwtService: JwtService) {

  def authenticate(): String = {
    if (isRequesterAuthentic()) {
      jwtService.createToken()
    } else {
      "\"message\":\"Access denied.\""
    }
  }

  private def isRequesterAuthentic(): Boolean = true
}
