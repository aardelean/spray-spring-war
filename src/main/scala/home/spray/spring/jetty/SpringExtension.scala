package home.spray.spring.jetty

import akka.actor.{Props, ExtendedActorSystem, Extension, AbstractExtensionId}
import org.springframework.context.ApplicationContext

/**
 * Created by alex on 3/28/2015.
 */
class SpringExtension extends AbstractExtensionId[SpringExt]{
  override def createExtension(system: ExtendedActorSystem): SpringExt = new SpringExt
}
object SpringExtension{
  val springExtensionProvider : SpringExtension = new SpringExtension()
}

