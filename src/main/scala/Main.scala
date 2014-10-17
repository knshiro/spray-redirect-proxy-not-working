import akka.actor.ActorSystem

import scala.concurrent.{Await, Future}

/**
 * Created by Ugo Bataillard on 10/17/14.
 */
object Main extends App {

  import spray.http._
  import spray.client.pipelining._
  import scala.concurrent.duration._

  implicit val system = ActorSystem("test")
  import system.dispatcher

  val pipeline: HttpRequest => Future[HttpResponse] = sendReceive

  val response: Future[HttpResponse] = pipeline(Get("http://next.rikunabi.com/rnc/docs/cp_s00700.jsp?wrk_plc_long_cd=0101100000"))
  val res = Await.result(response, 10 seconds)
  println("Result " + res.entity.asString)

}
