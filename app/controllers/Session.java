package controllers;

import is.ru.honn.rupin.data.UserDataGateway;
import is.ru.honn.rupin.domain.User;
import is.ru.honn.rupin.domain.UserAuthentication;
import play.data.Form;
import play.mvc.Result;
import views.html.index;
import views.html.session.loginform;

/**
 *  Session controller sér um loginForm, password validation og logout. Einnig sér
 *  hann líka að setja user í session og að hreinsa sessionið
 */

public class Session extends RuPinController {

    final static Form<UserAuthentication> loginForm = form(UserAuthentication.class);

    /**
     * Birtir Loginform
     * @return
     */
    public static Result loginForm() {
        return ok(loginform.render(loginForm));
    }

    /**
     * Sér um authentication af user með því að bera saman password sem user setur inn
     * við password sem sótt er í gagnagrunn
     * @return ef password passar þá birtist userhome view
     */
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

    /**
     * Sér um að hreinsa út session þegar loggað er út
     * @return skilaboð um að notandi er loggaður út
     */
    public static Result logout() {
        session().clear();            // session hreinsuð
        return ok("Bye");
    }
}

