package service

import org.http4s._
import org.http4s.dsl._

object Service {

  val service = HttpService {
    case GET -> Root => Ok("Hello")
  }
}
