package authapi.model

class Role extends Enumeration {
  type Role = Value
  val SuperAdmin, Admin, Moderator, User, Banned = Value
}
