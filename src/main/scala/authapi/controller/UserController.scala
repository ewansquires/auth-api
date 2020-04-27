package authapi.controller

import authapi.model.User
import authapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, PostMapping, RequestBody, RequestMapping, RestController}
import java.lang.Long
import java.lang.Iterable
import java.util.Optional

@RestController
@RequestMapping(path = Array("/user"))
class UserController @Autowired() (private val userService: UserService) {

  @PostMapping(path = Array("/create"))
  def saveUser(@RequestBody user: User) = userService.saveUser(user)

  @GetMapping(path = Array("/get/{id}"))
  def findUser(@PathVariable("id")id: Long): Optional[User] = userService.findUser(id)

  @GetMapping(path = Array("/all"))
  def listUsers(): Iterable[User] = userService.listUsers()

  @GetMapping(path = Array("/fill"))
  def fillUserRepository(): Unit = {
    val users = List(
      new User().withUsername("Amy").withRole("User"),
      new User().withUsername("Ben").withRole("Admin"),
      new User().withUsername("Charlie").withRole("Banned"),
      new User().withUsername("Devon").withRole("User"),
      new User().withUsername("Emily").withRole("Banned"),
      new User().withUsername("Ffion").withRole("User")
    )

    users.map(userService.saveUser)
  }
}
