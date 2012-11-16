
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.api.templates.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import com.avaje.ebean._
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main(Html("RuPin"))/*1.21*/ {_display_(Seq[Any](format.raw/*1.23*/("""
    
    <h2>Welcome!</h2>
    <p>
        You can:
        <a class="btn" href=""""),_display_(Seq[Any](/*6.31*/routes/*6.37*/.SignUp.blank)),format.raw/*6.50*/("""">Login</a>
        <a class="btn" href=""""),_display_(Seq[Any](/*7.31*/routes/*7.37*/.SignUp.blank)),format.raw/*7.50*/("""">Sign up</a>
    </p>
""")))})))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Nov 14 13:42:21 GMT 2012
                    SOURCE: C:/verkefni/skilaverkefni04/RuPin/app/views/index.scala.html
                    HASH: 6a226dc826419041601a906a0795df37dd3c609e
                    MATRIX: 828->1|855->20|894->22|1012->105|1026->111|1060->124|1137->166|1151->172|1185->185
                    LINES: 30->1|30->1|30->1|35->6|35->6|35->6|36->7|36->7|36->7
                    -- GENERATED --
                */
            