package controllers;

import is.ru.honn.rupin.data.BoardDataGateway;
import is.ru.honn.rupin.data.PinDataGateway;
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
import views.html.rupin.board;
import views.html.rupin.createpin;
import views.html.rupin.pinsummary;
import views.html.rupin.userhome;

import java.util.ArrayList;
import java.util.List;

/**
 * User: kristjant08@ru.is
 * Kristján Eldjárn Þóroddsson
 * Date: 18.11.2012
 * Time: 22:46
 */
public class Rupin extends RuPinController {

    final static Form<UserAuthentication> loginForm = form(UserAuthentication.class);
    final static Form<Pin> pinForm = form(Pin.class);

    public static Result userhome() {
        // loginForm = loginForm.fill(new UserAuthentication("user01", "Password"));
        Form<UserAuthentication> filledLoginForm = loginForm.bindFromRequest();
        UserDataGateway userDataGateway = (UserDataGateway) ctx.getBean("userDataGateway");
        //User u = userDataGateway.getUserByUsername(filledLoginForm.field("username").value());

        User u = userDataGateway.getUserByUsername(session().get("username"));
        UserAuthentication ua = filledLoginForm.get();

        if (null == u) {
            return ok(index.render());
        }
       // if (u.getPassword().equals(ua.getPassword())) {
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
            return ok(userhome.render(pins));
      //  } else {
       //     return ok(index.render());
       // }
    }

    public static Result blank() {
       //BoardDataGateway boardDataGateway = (BoardDataGateway) ctx.getBean("boardDataGateway");
        //List<Board> boards = boardDataGateway.getBoards(session().get("username"));
        //todo: koma þessum lista með í formið
        return ok(createpin.render(pinForm));
    }

    public static Result submit() {
        Form<Pin> filledForm = pinForm.bindFromRequest();
        if (filledForm.field("description").value().length() == 0) {
            filledForm.reject("description", "Please add in description");
        }
        if (filledForm.hasErrors()) {
            return badRequest(createpin.render(filledForm));
        } else {
            Pin created = filledForm.get();

            PinDataGateway pinDataGateway = (PinDataGateway) ctx.getBean("pinDataGateway");
            pinDataGateway.add(created, "MyFirstBoard", session().get("username"));

            return ok(pinsummary.render(created));
        }
    }

    public static Result getBoard(String boardName) {
        String user = session("connected");
        //if(user != null) {
            PinService pinService = (PinService) ctx.getBean("pinService");
            List<Pin> pins = pinService.getPinsOnBoard(session().get("username"), boardName);

            return ok(board.render(pins));
       // } else {
        //  return unauthorized("Oops, you are not connected");
        //}

    }


}
