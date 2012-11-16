
package views.html.session

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
object loginform extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[is.ru.honn.rupin.domain.UserAuthentication],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(loginForm: Form[is.ru.honn.rupin.domain.UserAuthentication]):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._

def /*6.2*/title/*6.7*/:play.api.templates.Html = {_display_(

Seq[Any](format.raw/*6.11*/("""
    Login
""")))};
Seq[Any](format.raw/*1.63*/("""

"""),format.raw/*5.1*/("""
"""),format.raw/*8.2*/("""

"""),_display_(Seq[Any](/*10.2*/main(title, nav = "login")/*10.28*/ {_display_(Seq[Any](format.raw/*10.30*/("""

    """),_display_(Seq[Any](/*12.6*/if(loginForm.hasErrors)/*12.29*/ {_display_(Seq[Any](format.raw/*12.31*/(""" <p>Login failed!</p> """)))})),format.raw/*12.54*/("""

    """),_display_(Seq[Any](/*14.6*/helper/*14.12*/.form(action = routes.Session.login)/*14.48*/ {_display_(Seq[Any](format.raw/*14.50*/("""
        <fieldset>
            <legend>Login</legend>
          """),_display_(Seq[Any](/*17.12*/inputText(
              loginForm("username"),
              '_label -> "Username"
          ))),format.raw/*20.12*/("""
          """),_display_(Seq[Any](/*21.12*/inputPassword(
                loginForm("password"),
                '_label -> "Password"
          ))),format.raw/*24.12*/("""
        </fieldset>

        <div class="actions">
            <input type="submit" class="btn primary" value="Login">
            <a href=""""),_display_(Seq[Any](/*29.23*/routes/*29.29*/.Application.index)),format.raw/*29.47*/("""" class="btn">Cancel</a>
        </div>
    """)))})),format.raw/*31.6*/("""
""")))})))}
    }
    
    def render(loginForm:Form[is.ru.honn.rupin.domain.UserAuthentication]) = apply(loginForm)
    
    def f:((Form[is.ru.honn.rupin.domain.UserAuthentication]) => play.api.templates.Html) = (loginForm) => apply(loginForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Nov 14 13:42:21 GMT 2012
                    SOURCE: C:/verkefni/skilaverkefni04/RuPin/app/views/session/loginform.scala.html
                    HASH: 5968266d8d2c7d4c70b3dd1fdbd40856c8c5ce3e
                    MATRIX: 809->1|980->117|992->122|1059->126|1110->62|1138->115|1165->138|1203->141|1238->167|1278->169|1320->176|1352->199|1392->201|1447->224|1489->231|1504->237|1549->273|1589->275|1691->341|1808->436|1856->448|1981->551|2159->693|2174->699|2214->717|2290->762
                    LINES: 27->1|32->6|32->6|34->6|37->1|39->5|40->8|42->10|42->10|42->10|44->12|44->12|44->12|44->12|46->14|46->14|46->14|46->14|49->17|52->20|53->21|56->24|61->29|61->29|61->29|63->31
                    -- GENERATED --
                */
            