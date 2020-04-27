package authapi.controller

import authapi.service.AuthenticationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping

@RestController
class AuthenticationController @Autowired() (private val authenticationService: AuthenticationService) {

  @PostMapping(path = Array("/authenticate"))
  def authenticate: String = authenticationService.authenticate()
}
