package home.spray.spring.jetty

import akka.actor.Actor.Receive
import akka.actor.{UntypedActor, ActorLogging, Actor}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import spray.http.HttpMethods._
import spray.http.{HttpResponse, Uri, HttpRequest}

/**
 * Created by alex on 3/28/2015.
 * Simple actor
 */
class Index(val service: Service) extends Actor with ActorLogging{

  override def receive = {
    case HttpRequest(GET, Uri.Path("/index"), _, _, _) =>
      sender ! HttpResponse(entity = service.htmlContent)
  }
}
