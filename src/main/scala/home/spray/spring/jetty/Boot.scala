package home.spray.spring.jetty

import akka.actor.{Props, ActorSystem}
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.scala.context.function.FunctionalConfigApplicationContext
import spray.servlet.WebBoot

// This class is instantiated by the servlet initializer.
// It can either define a constructor with a single
// `javax.servlet.ServletContext` parameter or a
// default constructor.
// It must implement the spray.servlet.WebBoot trait.
class Boot extends WebBoot {



  implicit val ctx = FunctionalConfigApplicationContext(classOf[FunctionalAppConfig])

  // we need an ActorSystem to host our application in
  val system = ctx.getBean(classOf[ActorSystem])
  SpringExtension.springExtensionProvider.get(system).initialize(ctx)

  // the service actor replies to incoming HttpRequests
  val serviceActor = system.actorOf(SpringExtension.springExtensionProvider.get(system).props("IndexActor"), "indexActor")

  system.registerOnTermination {
    // put additional cleanup code here
    system.log.info("Application shut down")
  }
}