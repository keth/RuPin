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
import views.html.rupin.board;
import views.html.rupin.createpin;
import views.html.rupin.pinSummary;
import views.html.rupin.userhome;

import java.util.ArrayList;
import java.util.List;

/**
 * Pupin controller sér um pinService virki, búa til pin, display-a pin og board.
 *   notandi verður að vera loggaður inn til að komast í þennan controller
 */
public class Rupin extends RuPinController {

    final static Form<UserAuthentication> loginForm = form(UserAuthentication.class);
    final static Form<Pin> pinForm = form(Pin.class);
    final static UserDataGateway userDataGateway = (UserDataGateway) ctx.getBean("userDataGateway");
    final static PinService pinService = (PinService) ctx.getBean("pinService");
    final static UserService userService = (UserService) ctx.getBean("userService");
    final static BoardDataGateway boardDataGateway = (BoardDataGateway) ctx.getBean("boardDataGateway");

    /**
     * Í þessu falli eru týndir til allir pinnar sem fylgja þeim notendum
     * sem innskráður notandi fylgir.
     * @return listi af pinnum sem birtast á userhome innskráðs notanda
     */
    public static Result userhome() {
        String user = session("connected");
        if (user != null) {
            userService.setUserDataGateway(userDataGateway);
            List<Pin> pins = new ArrayList<Pin>();
            List<String> followers = userDataGateway.getFollowers(session().get("username"));
            for (String f : followers) {
                List<Board> boards = boardDataGateway.getBoards(f);
                for (Board b : boards) {
                    List<Pin> followerPins = pinService.getPinsOnBoard(f, b.toString());
                    for (Pin fp : followerPins) {
                        pins.add(fp);
                    }
                }
            }
            return ok(userhome.render(pins));
        } else {
            return unauthorized("Oops, you are not connected ");
        }
    }

    /**
     *
     * @return
     */
    public static Result blank() {
        String user = session("connected");
        if (user != null) {
            return ok(createpin.render(pinForm));
        } else {
            return unauthorized("Oops, you are not connected");
        }
    }

    /**
     * submit fallið sér um að taka við upplýsingum þegar búinn er til
     * nýr pinni af innskráðum notanda
     * @return upplýsingar um nýgerðan pinna
     */
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

            return ok(pinSummary.render(created));
        }
    }

    /**
     * boardname fallið sér um að birta lista af öllum pinnum tengdum
     * ákveðunum borðum
     * @param boardName
     * @return  Listi af pinnum á ákveðnu borði
     */
    public static Result boardname(String boardName) {
        String user = session("connected");
        if (user != null) {
            User u = userDataGateway.getUserByUsername(session().get("username"));
            List<Pin> pins = new ArrayList<Pin>();
            List<String> followers = userDataGateway.getFollowers(u.getUsername());
            for (String f : followers) {
                List<Pin> followerPins = pinService.getPinsOnBoard(f, boardName);
                for (Pin fp : followerPins) {
                    pins.add(fp);
                }
            }
            return ok(board.render(pins));
        } else {
            return unauthorized("Oops, you are not connected");
        }
    }
}
