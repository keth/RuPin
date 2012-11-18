package controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

public class RuPinController extends Controller
{
  protected static ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/ApplicationContext.xml");

    //@Override
    public String getUsername(Http.Context ctx) {
        return ctx.session().get("username");
    }

    //@Override
    public Result onUnauthorized(Http.Context ctx) {
        return redirect(routes.Session.loginForm());
    }

}
