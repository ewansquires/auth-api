package authapi.service

import authapi.model.User
import authapi.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Long
import java.util.Optional

import play.api.libs.json.Json

@Service
class UserService @Autowired()(private val userRepository: UserRepository, private val jwtService: JwtService) {

  def listUsers(token: String): Object = {
    if (isAdmin(token)) {
      userRepository.findAll()
    } else {
      "{\"message\":\"Access Denied.\"}"
    }
  }

  def findUser(id: Long): Optional[User] = userRepository.findById(id)

  def saveUser(user: User) = userRepository.save(user)

  def fillRepository(): Unit = {
    val users = List(
      new User().withUsername("Amy").withRole("User"),
      new User().withUsername("Ben").withRole("Admin"),
      new User().withUsername("Charlie").withRole("Banned"),
      new User().withUsername("Devon").withRole("User"),
      new User().withUsername("Emily").withRole("Banned"),
      new User().withUsername("Ffion").withRole("User")
    )

    users.map(saveUser)
  }

  def isRequesterAuthentic(user: User) = ! (findUser(user.getId()).get().getRole() == "Banned")

  private def isAdmin(token: String): Boolean = isRole("Admin", token)

  private def isRole(role: String, token: String): Boolean = {
    val payload = Json.parse(jwtService.getMessageFromToken(token))
    val tokenRole = (payload \ "role").get.toString().replace("\"", "")
    tokenRole.equals(role)
  }
}
