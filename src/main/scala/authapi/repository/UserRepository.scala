package authapi.repository

import authapi.model.User
import org.springframework.data.repository.CrudRepository

trait UserRepository extends CrudRepository[User, Long]
