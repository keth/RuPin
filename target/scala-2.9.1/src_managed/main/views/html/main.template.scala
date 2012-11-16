
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Html,String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: Html, nav: String = "")(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.48*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>RuPin</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/bootstrap.css"))),format.raw/*8.99*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png"))),format.raw/*9.97*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*10.74*/("""" type="text/javascript"></script>
    </head>
    <body>
        
        <div class="topbar">
            <div class="fill">
                <div class="container">
                    <a class="brand" href=""""),_display_(Seq[Any](/*17.45*/routes/*17.51*/.Application.index())),format.raw/*17.71*/("""">RuPin</a>&nbsp;
                           <a href=""""),_display_(Seq[Any](/*18.38*/routes/*18.44*/.SignUp.blank)),format.raw/*18.57*/("""">Sign up</a>&nbsp;
                           <a href=""""),_display_(Seq[Any](/*19.38*/routes/*19.44*/.Session.loginForm)),format.raw/*19.62*/("""">Login</a>&nbsp;
                </div>
            </div>
        </div>

        <div class="container">

            <div class="content">
                
                <div class="page-header">
                    <h1>"""),_display_(Seq[Any](/*29.26*/title)),format.raw/*29.31*/("""</h1>
                </div>

                <div class="row">
                    <div class="span14">
                        """),_display_(Seq[Any](/*34.26*/content)),format.raw/*34.33*/("""
                    </div>
                </div>
                
            </div>

            <footer>
                <p>
                    RuPin
                </p>
            </footer>

        </div>
        
    </body>
</html>
"""))}
    }
    
    def render(title:Html,nav:String,content:Html) = apply(title,nav)(content)
    
    def f:((Html,String) => (Html) => play.api.templates.Html) = (title,nav) => (content) => apply(title,nav)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Nov 14 13:42:21 GMT 2012
                    SOURCE: C:/verkefni/skilaverkefni04/RuPin/app/views/main.scala.html
                    HASH: b629da16709d77e6089300c74297fdfd3917e0d0
                    MATRIX: 764->1|887->47|1041->166|1055->172|1115->211|1211->272|1225->278|1278->310|1339->335|1354->341|1421->386|1668->597|1683->603|1725->623|1816->678|1831->684|1866->697|1959->754|1974->760|2014->778|2277->1005|2304->1010|2470->1140|2499->1147
                    LINES: 27->1|30->1|37->8|37->8|37->8|38->9|38->9|38->9|39->10|39->10|39->10|46->17|46->17|46->17|47->18|47->18|47->18|48->19|48->19|48->19|58->29|58->29|63->34|63->34
                    -- GENERATED --
                */
            