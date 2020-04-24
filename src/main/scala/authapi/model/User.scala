package authapi.model

import javax.persistence.{Entity, GeneratedValue, GenerationType, Id}

@Entity
class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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

  def getId(): Long = id

  def getUsername(): String = username

  def setUsername(username: String) = this.username = username

  def getRole(): String = role

  def setRole(role: String) = this.role = role
}
