// @SOURCE:C:/Users/Lenovo/IdeaProjects/GitHub/RuPin/conf/routes
// @HASH:c482f4010122836ee603359b09f4c6dfdb7f5d2a
// @DATE:Tue Nov 20 11:53:04 GMT 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:9
val controllers_SignUp_blank1 = Route("GET", PathPattern(List(StaticPart("/signup"))))
                    

// @LINE:10
val controllers_SignUp_submit2 = Route("POST", PathPattern(List(StaticPart("/signup"))))
                    

// @LINE:13
val controllers_Session_loginForm3 = Route("GET", PathPattern(List(StaticPart("/loginform"))))
                    

// @LINE:14
val controllers_Session_authenticate4 = Route("POST", PathPattern(List(StaticPart("/loginform"))))
                    

// @LINE:15
val controllers_Rupin_userhome5 = Route("GET", PathPattern(List(StaticPart("/userhome"))))
                    

// @LINE:16
val controllers_Session_logout6 = Route("GET", PathPattern(List(StaticPart("/logout"))))
                    

// @LINE:22
val controllers_Rupin_blank7 = Route("GET", PathPattern(List(StaticPart("/createpin"))))
                    

// @LINE:23
val controllers_Rupin_submit8 = Route("POST", PathPattern(List(StaticPart("/createpin"))))
                    

// @LINE:26
val controllers_Assets_at9 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.index()"""),("""GET""","""/signup""","""controllers.SignUp.blank()"""),("""POST""","""/signup""","""controllers.SignUp.submit()"""),("""GET""","""/loginform""","""controllers.Session.loginForm()"""),("""POST""","""/loginform""","""controllers.Session.authenticate()"""),("""GET""","""/userhome""","""controllers.Rupin.userhome()"""),("""GET""","""/logout""","""controllers.Session.logout()"""),("""GET""","""/createpin""","""controllers.Rupin.blank()"""),("""POST""","""/createpin""","""controllers.Rupin.submit()"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:9
case controllers_SignUp_blank1(params) => {
   call { 
        invokeHandler(_root_.controllers.SignUp.blank(), HandlerDef(this, "controllers.SignUp", "blank", Nil))
   }
}
                    

// @LINE:10
case controllers_SignUp_submit2(params) => {
   call { 
        invokeHandler(_root_.controllers.SignUp.submit(), HandlerDef(this, "controllers.SignUp", "submit", Nil))
   }
}
                    

// @LINE:13
case controllers_Session_loginForm3(params) => {
   call { 
        invokeHandler(_root_.controllers.Session.loginForm(), HandlerDef(this, "controllers.Session", "loginForm", Nil))
   }
}
                    

// @LINE:14
case controllers_Session_authenticate4(params) => {
   call { 
        invokeHandler(_root_.controllers.Session.authenticate(), HandlerDef(this, "controllers.Session", "authenticate", Nil))
   }
}
                    

// @LINE:15
case controllers_Rupin_userhome5(params) => {
   call { 
        invokeHandler(_root_.controllers.Rupin.userhome(), HandlerDef(this, "controllers.Rupin", "userhome", Nil))
   }
}
                    

// @LINE:16
case controllers_Session_logout6(params) => {
   call { 
        invokeHandler(_root_.controllers.Session.logout(), HandlerDef(this, "controllers.Session", "logout", Nil))
   }
}
                    

// @LINE:22
case controllers_Rupin_blank7(params) => {
   call { 
        invokeHandler(_root_.controllers.Rupin.blank(), HandlerDef(this, "controllers.Rupin", "blank", Nil))
   }
}
                    

// @LINE:23
case controllers_Rupin_submit8(params) => {
   call { 
        invokeHandler(_root_.controllers.Rupin.submit(), HandlerDef(this, "controllers.Rupin", "submit", Nil))
   }
}
                    

// @LINE:26
case controllers_Assets_at9(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                