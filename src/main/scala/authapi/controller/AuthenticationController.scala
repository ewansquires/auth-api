package authapi.controller

import authapi.model.User
import authapi.service.AuthenticationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{PostMapping, RequestBody, RestController}

@RestController
class AuthenticationController @Autowired() (private val authenticationService: AuthenticationService) {

  @PostMapping(path = Array("/authenticate"))
  def authenticate(@RequestBody user: User): String = authenticationService.authenticate(user)
}
