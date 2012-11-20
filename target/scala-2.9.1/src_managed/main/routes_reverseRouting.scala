// @SOURCE:C:/Users/Lenovo/IdeaProjects/GitHub/RuPin/conf/routes
// @HASH:c482f4010122836ee603359b09f4c6dfdb7f5d2a
// @DATE:Tue Nov 20 11:53:04 GMT 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:26
class ReverseAssets {
    


 
// @LINE:26
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            

// @LINE:10
// @LINE:9
class ReverseSignUp {
    


 
// @LINE:10
def submit() = {
   Call("POST", "/signup")
}
                                                        
 
// @LINE:9
def blank() = {
   Call("GET", "/signup")
}
                                                        

                      
    
}
                            

// @LINE:16
// @LINE:14
// @LINE:13
class ReverseSession {
    


 
// @LINE:14
def authenticate() = {
   Call("POST", "/loginform")
}
                                                        
 
// @LINE:16
def logout() = {
   Call("GET", "/logout")
}
                                                        
 
// @LINE:13
def loginForm() = {
   Call("GET", "/loginform")
}
                                                        

                      
    
}
                            

// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def index() = {
   Call("GET", "/")
}
                                                        

                      
    
}
                            

// @LINE:23
// @LINE:22
// @LINE:15
class ReverseRupin {
    


 
// @LINE:23
def submit() = {
   Call("POST", "/createpin")
}
                                                        
 
// @LINE:22
def blank() = {
   Call("GET", "/createpin")
}
                                                        
 
// @LINE:15
def userhome() = {
   Call("GET", "/userhome")
}
                                                        

                      
    
}
                            
}
                    


// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:26
class ReverseAssets {
    


 
// @LINE:26
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:10
// @LINE:9
class ReverseSignUp {
    


 
// @LINE:10
def submit = JavascriptReverseRoute(
   "controllers.SignUp.submit",
   """
      function() {
      return _wA({method:"POST", url:"/signup"})
      }
   """
)
                                                        
 
// @LINE:9
def blank = JavascriptReverseRoute(
   "controllers.SignUp.blank",
   """
      function() {
      return _wA({method:"GET", url:"/signup"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:16
// @LINE:14
// @LINE:13
class ReverseSession {
    


 
// @LINE:14
def authenticate = JavascriptReverseRoute(
   "controllers.Session.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"/loginform"})
      }
   """
)
                                                        
 
// @LINE:16
def logout = JavascriptReverseRoute(
   "controllers.Session.logout",
   """
      function() {
      return _wA({method:"GET", url:"/logout"})
      }
   """
)
                                                        
 
// @LINE:13
def loginForm = JavascriptReverseRoute(
   "controllers.Session.loginForm",
   """
      function() {
      return _wA({method:"GET", url:"/loginform"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"/"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:23
// @LINE:22
// @LINE:15
class ReverseRupin {
    


 
// @LINE:23
def submit = JavascriptReverseRoute(
   "controllers.Rupin.submit",
   """
      function() {
      return _wA({method:"POST", url:"/createpin"})
      }
   """
)
                                                        
 
// @LINE:22
def blank = JavascriptReverseRoute(
   "controllers.Rupin.blank",
   """
      function() {
      return _wA({method:"GET", url:"/createpin"})
      }
   """
)
                                                        
 
// @LINE:15
def userhome = JavascriptReverseRoute(
   "controllers.Rupin.userhome",
   """
      function() {
      return _wA({method:"GET", url:"/userhome"})
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {

// @LINE:26
class ReverseAssets {
    


 
// @LINE:26
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            

// @LINE:10
// @LINE:9
class ReverseSignUp {
    


 
// @LINE:10
def submit() = new play.api.mvc.HandlerRef(
   controllers.SignUp.submit(), HandlerDef(this, "controllers.SignUp", "submit", Seq())
)
                              
 
// @LINE:9
def blank() = new play.api.mvc.HandlerRef(
   controllers.SignUp.blank(), HandlerDef(this, "controllers.SignUp", "blank", Seq())
)
                              

                      
    
}
                            

// @LINE:16
// @LINE:14
// @LINE:13
class ReverseSession {
    


 
// @LINE:14
def authenticate() = new play.api.mvc.HandlerRef(
   controllers.Session.authenticate(), HandlerDef(this, "controllers.Session", "authenticate", Seq())
)
                              
 
// @LINE:16
def logout() = new play.api.mvc.HandlerRef(
   controllers.Session.logout(), HandlerDef(this, "controllers.Session", "logout", Seq())
)
                              
 
// @LINE:13
def loginForm() = new play.api.mvc.HandlerRef(
   controllers.Session.loginForm(), HandlerDef(this, "controllers.Session", "loginForm", Seq())
)
                              

                      
    
}
                            

// @LINE:6
class ReverseApplication {
    


 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              

                      
    
}
                            

// @LINE:23
// @LINE:22
// @LINE:15
class ReverseRupin {
    


 
// @LINE:23
def submit() = new play.api.mvc.HandlerRef(
   controllers.Rupin.submit(), HandlerDef(this, "controllers.Rupin", "submit", Seq())
)
                              
 
// @LINE:22
def blank() = new play.api.mvc.HandlerRef(
   controllers.Rupin.blank(), HandlerDef(this, "controllers.Rupin", "blank", Seq())
)
                              
 
// @LINE:15
def userhome() = new play.api.mvc.HandlerRef(
   controllers.Rupin.userhome(), HandlerDef(this, "controllers.Rupin", "userhome", Seq())
)
                              

                      
    
}
                            
}
                    
                