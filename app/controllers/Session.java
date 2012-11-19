package controllers;

import is.ru.honn.rupin.data.BoardDataGateway;
import is.ru.honn.rupin.data.UserDataGateway;
import is.ru.honn.rupin.domain.Board;
import is.ru.honn.rupin.domain.Pin;
import is.ru.honn.rupin.domain.User;
import is.ru.honn.rupin.domain.UserAuthentication;
import is.ru.honn.rupin.service.PinService;
import is.ru.honn.rupin.service.UserService;
import play.data.Form;
import play.mvc.Result;
import views.html.index;
import views.html.session.board;
import views.html.session.login;
import views.html.session.loginform;

import java.util.ArrayList;
import java.util.List;

public class Session extends RuPinController {
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
        }
        if (u.getPassword().equals(ua.getPassword())) {
            return redirect(routes.Session.login());
        } else {
            return ok(index.render());
        }
    }

    public static Result login() {
        // loginForm = loginForm.fill(new UserAuthentication("user01", "Password"));
        Form<UserAuthentication> filledLoginForm = loginForm.bindFromRequest();
        UserDataGateway userDataGateway = (UserDataGateway) ctx.getBean("userDataGateway");
        User u = userDataGateway.getUserByUsername(filledLoginForm.field("username").value());
        UserAuthentication ua = filledLoginForm.get();

        if (null == u) {
            return ok(index.render());
        }
        if (u.getPassword().equals(ua.getPassword())) {
            PinService pinService = (PinService) ctx.getBean("pinService");
            UserService userService = (UserService) ctx.getBean("userService");
            userService.setUserDataGateway(userDataGateway);

            BoardDataGateway boardDataGateway = (BoardDataGateway) ctx.getBean("boardDataGateway");


            List<Pin> pins = new ArrayList<Pin>();
            List<String> followers = userDataGateway.getFollowers(u.getUsername());
            for (String f : followers) {
                List<Board> boards = boardDataGateway.getBoards(f);
                for (Board b : boards){
                    List<Pin> followerPins = pinService.getPinsOnBoard(f, b.toString());
                    for (Pin fp : followerPins) {
                        pins.add(fp);
                    }
                }
            }
            return ok(login.render(pins));
        } else {
            return ok(index.render());
        }
    }

    public static Result logout() {
        return ok(index.render());
        // TODO: gera logout
    }

    public static Result getBoard(String boardName){
        PinService pinService = (PinService) ctx.getBean("pinService");
        List<Pin> pins = pinService.getPinsOnBoard("keth", boardName);


        return ok(board.render(pins));
        //return ok(index.render());

    }



}

