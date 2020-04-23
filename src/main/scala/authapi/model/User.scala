package authapi.model

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id
import javax.persistence.{GeneratedValue, GenerationType}

class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long = _

  var username: String = _

  var role: String = _

  def withUsername(username: String): User = {
    this.username = username
    this
  }

  def withRole(role: String): User = {
    this.role = role
    this
  }
}
