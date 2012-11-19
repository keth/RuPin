package controllers;

import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;

/**
 * User: kristjant08@ru.is
 * Kristján Eldjárn Þóroddsson
 * Date: 19.11.2012
 * Time: 12:12
 */
public class Secured extends Security.Authenticator {

    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("username");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.SignUp.blank());
    }


}
