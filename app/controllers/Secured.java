package controllers;

import play.mvc.Security;

/**
 *  ekki í notkun má henda!!!
 */
public class Secured extends Security.Authenticator {
   /*
    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("username");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return redirect(routes.SignUp.blank());
    }

        */
}
