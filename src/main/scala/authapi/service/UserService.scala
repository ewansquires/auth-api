package authapi.service

import authapi.UserRepository
import authapi.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Long
import java.lang.Iterable
import java.util.Optional

@Service
class UserService @Autowired()(private val userRepository: UserRepository)  {

  def listUsers(): Iterable[User] = userRepository.findAll()

  @throws(classOf[Exception])
  def findUser(id: Long): Optional[User] = userRepository.findById(id)

  def saveUser(user: User) = userRepository.save(user)

}
