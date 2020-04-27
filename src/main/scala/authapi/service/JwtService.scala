package authapi.service

import org.springframework.stereotype.Service
import pdi.jwt.{Jwt, JwtAlgorithm}

@Service
class JwtService {
  val SECRET_KEY = "Scala"

  def createToken(): String = Jwt.encode("\"message\":\"Hello, World!\"", SECRET_KEY, JwtAlgorithm.HS256)

  def getMessageFromToken(token: String): String = Jwt.decodeRawAll(token, SECRET_KEY, Seq(JwtAlgorithm.HS256)).get._2
}
