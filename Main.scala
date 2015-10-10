import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.{ ActorMaterializer, Materializer }
import org.json4s.{ DefaultFormats, native }
import scala.concurrent.ExecutionContext
import scala.io.StdIn

object Main {
  case class Foo(bar: String)
  {require(bar.nonEmpty, "name is required")}

  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem()
    implicit val mat = ActorMaterializer()
    import system.dispatcher

    Http().bindAndHandle(route, "127.0.0.1", 8080)

    StdIn.readLine("Hit ENTER to exit")
    system.terminate()
  }

  def route(implicit ec: ExecutionContext, mat: Materializer) = {
    import akka.http.scaladsl.server.Directives._
    import de.heikoseeberger.akkahttpjson4s.Json4sSupport._

    implicit val serialization = native.Serialization
    implicit val formats = DefaultFormats

    path("") {
      post {
        entity(as[Foo]) { foo =>
          complete {
            foo
          }
        }
      }
    }
  }
}
