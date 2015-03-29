package home.spray.spring.jetty

import akka.actor.ActorSystem
import org.springframework.beans.factory.config.{Scope, BeanDefinition}
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.scala.context.function.FunctionalConfiguration

/**
 * Created by alex on 3/29/2015.
 *
 * This is for instantiating AKKA actors classes.
 */
class FunctionalAppConfig  extends FunctionalConfiguration{

  importClass(classOf[AppConfiguration])

  implicit val ctx = beanFactory.asInstanceOf[ApplicationContext]



  val actorSystem = bean("actorSystem",  scope = BeanDefinition.SCOPE_SINGLETON) {
    val system = ActorSystem("AkkaScalaSpring")
    system
  }

  val index = prototype("IndexActor") {
    new Index(ctx.getBean(classOf[Service]))
  }

}
