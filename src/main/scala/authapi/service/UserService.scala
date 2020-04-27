package authapi.service

import authapi.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Long
import java.lang.Iterable
import java.util.Optional

import authapi.repository.UserRepository

@Service
class UserService @Autowired()(private val userRepository: UserRepository)  {

  def listUsers(): Iterable[User] = userRepository.findAll()

  def findUser(id: Long): Optional[User] = userRepository.findById(id)

  def saveUser(user: User) = userRepository.save(user)
}
