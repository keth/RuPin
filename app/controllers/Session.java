package controllers;

import is.ru.honn.rupin.data.UserDataGateway;
import is.ru.honn.rupin.domain.User;
import is.ru.honn.rupin.domain.UserAuthentication;
import play.data.Form;
import play.mvc.Result;
import views.html.index;
import views.html.session.login;
import views.html.session.loginform;

public class Session extends RuPinController {
    final static Form<UserAuthentication> loginForm = form(UserAuthentication.class);


    public static Result loginForm() {
        return ok(loginform.render(loginForm));
    }

    public static Result login() {
        UserDataGateway userDataGateway = (UserDataGateway)ctx.getBean("userDataGateway");
        User user = userDataGateway.getUserByUsername("qwer"); // TODO: laga user
        return ok(login.render(user));
        //return ok(main.render());
    }

    public static Result logout(){
        return ok(index.render());
        // TODO: gera logout
    }


}

