package controllers;

import is.ru.honn.rupin.data.UserDataGateway;
import is.ru.honn.rupin.domain.User;
import is.ru.honn.rupin.domain.UserAuthentication;
import play.data.Form;
import play.mvc.Result;
import views.html.index;
import views.html.session.loginform;

public class Session extends RuPinController {

    //þessi controller sér um loginForm, password validation, logout.  og líka að setja user í
    // session og að clera sessionið
    final static Form<UserAuthentication> loginForm = form(UserAuthentication.class);

    public static Result loginForm() {
        return ok(loginform.render(loginForm));
    }

    public static Result authenticate() {
        Form<UserAuthentication> filledLoginForm = loginForm.bindFromRequest();
        UserDataGateway userDataGateway = (UserDataGateway) ctx.getBean("userDataGateway");
        User u = userDataGateway.getUserByUsername(filledLoginForm.field("username").value());
        UserAuthentication ua = filledLoginForm.get();
        if (null == u) {
            return ok(index.render());
        } if (u.getPassword().equals(ua.getPassword())) {
            session().put("username", u.getUsername());     // User settur í session
            return redirect(routes.Rupin.userhome());       // ...og redirectað á userhome
        } else {
            return ok(index.render());
        }
    }

    public static Result logout() {
        session().clear();            // session hreinsuð
        return ok("Bye");
    }
}

