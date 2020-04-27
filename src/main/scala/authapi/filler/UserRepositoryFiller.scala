package authapi.filler

import authapi.model.User
import authapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.{ApplicationArguments, ApplicationRunner}

class UserRepositoryFiller @Autowired() (userService: UserService) extends ApplicationRunner {
  def run(args: ApplicationArguments) = {

  }
}
