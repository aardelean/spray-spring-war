package home.spray.spring.jetty

import akka.actor.{Props, ActorSystem}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.{ComponentScan, Bean, Configuration}
import org.springframework.scala.context.function.FunctionalConfiguration

/**
 * Created by alex on 3/28/2015.
 * Normal spring configuration. Not sure why this could be needed at the moment, but could prove useful to have DI in
 * Spray application maybe in the future.
 */
@Configuration
class AppConfiguration{

  @Bean def createService(): Service = new Service

  @Bean def createHtmlProvider(): HtmlProvider = new HtmlProvider
}
