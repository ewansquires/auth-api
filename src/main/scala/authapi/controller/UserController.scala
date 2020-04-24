package authapi.controller

import authapi.model.User
import authapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, PostMapping, RequestMapping, RestController}
import java.lang.Long
import java.lang.Iterable

@RestController
@RequestMapping(path = Array("/user"))
class UserController @Autowired() (private val userService: UserService) {

  @PostMapping(path = Array("/create"))
  def createUser() = {
    val user = new User().withUsername("Adam").withRole("Software Engineer")
    userService.createUser(user)
  }

  @GetMapping(path = Array("/get/{id}"))
  def findUser(@PathVariable("id")id: Long) = userService.findUser(id)

  @GetMapping(path = Array("/all"))
  def listUsers(): Iterable[User] = userService.listUsers()
}
