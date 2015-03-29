package home.spray.spring.jetty

import akka.actor.{Actor, IndirectActorProducer}
import org.slf4j.{LoggerFactory, Logger}
import org.springframework.context.ApplicationContext

/**
 * Created by alex on 3/28/2015.
 * Wrapper for creating actors with dependency injection
 */
class SpringActorProducer(val applicationContext :ApplicationContext,  val actorBeanName : String) extends IndirectActorProducer{
  val log : Logger = LoggerFactory.getLogger(classOf[SpringActorProducer])

  override def produce(): Actor = applicationContext.getBean(actorBeanName, classOf[Actor]);

  override def actorClass: Class[_ <: Actor] = {
    applicationContext.getType(actorBeanName).asInstanceOf[Class[_ <: Actor]]
  }
}
