
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

    <h1>RuPin</h1>
    <h2>Welcome!</h2>
    <p>
        <!-- if user loggaður in Liður 2 -->



        You can:
        <!--<a class="btn" href=""""),_display_(Seq[Any](/*11.35*/routes/*11.41*/.SignUp.blank)),format.raw/*11.54*/("""">Login</a>   -->
        <a class="btn" href=""""),_display_(Seq[Any](/*12.31*/routes/*12.37*/.Session.loginForm)),format.raw/*12.55*/("""">Login</a>
        <a class="btn" href=""""),_display_(Seq[Any](/*13.31*/routes/*13.37*/.SignUp.blank)),format.raw/*13.50*/("""">Sign up</a>
    </p>
""")))})))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Nov 20 08:36:52 GMT 2012
                    SOURCE: C:/Users/Lenovo/IdeaProjects/GitHub/RuPin/app/views/index.scala.html
                    HASH: a40f333dee95ace5a07f436bf40557018bbd028e
                    MATRIX: 828->1|855->20|894->22|1080->172|1095->178|1130->191|1214->239|1229->245|1269->263|1347->305|1362->311|1397->324
                    LINES: 30->1|30->1|30->1|40->11|40->11|40->11|41->12|41->12|41->12|42->13|42->13|42->13
                    -- GENERATED --
                */
            