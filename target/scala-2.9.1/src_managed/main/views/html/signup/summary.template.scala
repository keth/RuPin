
package views.html.signup

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
object summary extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[is.ru.honn.rupin.domain.User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user: is.ru.honn.rupin.domain.User):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.38*/("""

"""),_display_(Seq[Any](/*3.2*/main(Html("Account created!"), nav = "signup")/*3.48*/ {_display_(Seq[Any](format.raw/*3.50*/("""
    
    <h2>Your account:</h2>
    <p>Name: """),_display_(Seq[Any](/*6.15*/user/*6.19*/.getName())),format.raw/*6.29*/("""</p>
    <p>Username: """),_display_(Seq[Any](/*7.19*/user/*7.23*/.getUsername())),format.raw/*7.37*/("""</p>
    <p>Email: """),_display_(Seq[Any](/*8.16*/user/*8.20*/.getEmail())),format.raw/*8.31*/("""</p>

    Go here to: <a href=""""),_display_(Seq[Any](/*10.27*/routes/*10.33*/.Session.loginForm)),format.raw/*10.51*/("""">Login</a>
""")))})))}
    }
    
    def render(user:is.ru.honn.rupin.domain.User) = apply(user)
    
    def f:((is.ru.honn.rupin.domain.User) => play.api.templates.Html) = (user) => apply(user)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Nov 14 13:42:21 GMT 2012
                    SOURCE: C:/verkefni/skilaverkefni04/RuPin/app/views/signup/summary.scala.html
                    HASH: 10fa3a61d28509ee8d646929ac439a70042ef835
                    MATRIX: 786->1|899->37|936->40|990->86|1029->88|1111->135|1123->139|1154->149|1212->172|1224->176|1259->190|1314->210|1326->214|1358->225|1426->257|1441->263|1481->281
                    LINES: 27->1|30->1|32->3|32->3|32->3|35->6|35->6|35->6|36->7|36->7|36->7|37->8|37->8|37->8|39->10|39->10|39->10
                    -- GENERATED --
                */
            