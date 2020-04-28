package authapi.controller

import authapi.model.User
import authapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, PostMapping, RequestBody, RequestHeader, RequestMapping, ResponseBody, RestController}
import java.lang.Long
import java.util.Optional

@RestController
@RequestMapping(path = Array("/user"))
class UserController @Autowired() (private val userService: UserService) {

  @PostMapping(path = Array("/create"))
  def saveUser(@RequestBody user: User): Unit = userService.saveUser(user)

  @GetMapping(path = Array("/get/{id}"))
  def findUser(@PathVariable("id")id: Long): Optional[User] = userService.findUser(id)

  @GetMapping(path = Array("/all"))
  def listUsers(@RequestHeader("authorization") token: String): Object = userService.listUsers(token)

  @GetMapping(path = Array("/fill"))
  def fillUserRepository(): Unit = userService.fillRepository()
}
