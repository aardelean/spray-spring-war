package home.spray.spring.jetty

import akka.actor.{Props, Extension}
import org.springframework.context.ApplicationContext

/**
 * Created by alex on 3/28/2015.
 */
class SpringExt extends Extension{
  @volatile
  var applicationContext: ApplicationContext = null

  /**
   * Used to initialize the Spring application context for the extension.
   * @param applicationContext
   */
  def initialize(applicationContext: ApplicationContext) {
    this.applicationContext = applicationContext
  }

  def props(actorBeanName : String) : Props = Props(classOf[SpringActorProducer],applicationContext,actorBeanName)
}