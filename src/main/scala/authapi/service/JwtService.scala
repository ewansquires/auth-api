package authapi.service

import authapi.model.User
import org.springframework.stereotype.Service
import pdi.jwt.{Jwt, JwtAlgorithm}

@Service
class JwtService {
  val SECRET_KEY = "Scala"

  def createToken(user: User): String = Jwt.encode(user.toJsonString(), SECRET_KEY, JwtAlgorithm.HS256)

  def getMessageFromToken(token: String): String = Jwt.decodeRawAll(token, SECRET_KEY, Seq(JwtAlgorithm.HS256)).get._2
}
