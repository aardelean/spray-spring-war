package home.spray.spring.jetty


import org.springframework.beans.factory.annotation.{Autowired, Qualifier}

/**
 * Created by alex on 3/28/2015.
 */
class Service {

  @Autowired
  var htmlProvider : HtmlProvider = _

  def htmlContent = htmlProvider.fetchHtml()
}
