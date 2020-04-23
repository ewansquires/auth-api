package authapi.model

class User {

  var id: Long = _

  var username: String = _

  var role: String = _

  def withId(id: Int): User = {
    this.id = id
    this
  }

  def withUsername(username: String): User = {
    this.username = username
    this
  }

  def withRole(role: String): User = {
    this.role = role
    this
  }

  def getId() = id

  def setId(id: Int) = this.id = id

  def getUsername() = username

  def setUsername(username: String) = this.username = username

  def getRole() = role

  def setRole(role: String) = this.role = role
}
