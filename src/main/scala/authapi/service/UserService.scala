package authapi.service

import authapi.model.User
import authapi.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Long
import java.lang.Iterable
import java.util.Optional

@Service
class UserService @Autowired()(private val userRepository: UserRepository)  {

  def listUsers(): Iterable[User] = userRepository.findAll()

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
}
