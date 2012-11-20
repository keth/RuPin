
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
        
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="brand" href=""""),_display_(Seq[Any](/*17.45*/routes/*17.51*/.Application.index())),format.raw/*17.71*/("""">RuPin</a>&nbsp;
                    <a class="brand"<a href=""""),_display_(Seq[Any](/*18.47*/routes/*18.53*/.SignUp.blank)),format.raw/*18.66*/("""">Sign up</a>&nbsp;
                    <a class="brand"<a href=""""),_display_(Seq[Any](/*19.47*/routes/*19.53*/.Session.loginForm)),format.raw/*19.71*/("""">Login</a>&nbsp;
                </div>
            </div>
        </div>

        <div class="container">

            <div class="content">
                
                <div class="page-header">

                </div>
                <div class="hero-unit">

                <div class="row">
                    <div class="span14">

                        """),_display_(Seq[Any](/*36.26*/content)),format.raw/*36.33*/("""
                    </div>
                </div>
                </div>
            </div>
             <hr>
            <footer>
                <p>
                    RuPin 2012
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
                    DATE: Tue Nov 20 08:36:52 GMT 2012
                    SOURCE: C:/Users/Lenovo/IdeaProjects/GitHub/RuPin/app/views/main.scala.html
                    HASH: 762a65dad865c5a7f265867327b4e2d26961daf3
                    MATRIX: 764->1|887->47|1041->166|1055->172|1115->211|1211->272|1225->278|1278->310|1339->335|1354->341|1421->386|1708->637|1723->643|1765->663|1865->727|1880->733|1915->746|2017->812|2032->818|2072->836|2476->1204|2505->1211
                    LINES: 27->1|30->1|37->8|37->8|37->8|38->9|38->9|38->9|39->10|39->10|39->10|46->17|46->17|46->17|47->18|47->18|47->18|48->19|48->19|48->19|65->36|65->36
                    -- GENERATED --
                */
            