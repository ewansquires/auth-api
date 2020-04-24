package authapi

import org.springframework.data.repository.CrudRepository
import java.lang.Long

import authapi.model.User

trait UserRepository extends CrudRepository[User, Long]
