package authapi.controller

import authapi.model.User
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{GetMapping, PostMapping, RequestMapping, RestController}

@RestController
@RequestMapping(path = Array("/user"))
class UserController {
  @GetMapping(path = Array("/create"))
  def create(): User = {
    new User().withId(1).withUsername("Adam").withRole("Software Engineer")
  }
}
