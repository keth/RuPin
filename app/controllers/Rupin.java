package controllers;

import is.ru.honn.rupin.data.BoardDataGateway;
import is.ru.honn.rupin.data.PinDataGateway;
import is.ru.honn.rupin.data.UserDataGateway;
import is.ru.honn.rupin.domain.Board;
import is.ru.honn.rupin.domain.Pin;
import is.ru.honn.rupin.domain.UserAuthentication;
import is.ru.honn.rupin.service.PinService;
import is.ru.honn.rupin.service.UserService;
import play.data.Form;
import play.mvc.Result;
import views.html.rupin.board;
import views.html.rupin.createpin;
import views.html.rupin.pinsummary;
import views.html.rupin.userhome;

import java.util.ArrayList;
import java.util.List;

/**
 *  Rupin controller sér um pinService virkni, búa til pin, display-a pin og board.
 *   notandi verður að vera loggaður inn til að komast í þennan controller
 */
public class Rupin extends RuPinController {

    final static Form<UserAuthentication> loginForm = form(UserAuthentication.class);
    final static Form<Pin> pinForm = form(Pin.class);
    final static PinService pinService = (PinService) ctx.getBean("pinService");
    final static UserService userService = (UserService) ctx.getBean("userService");
    final static UserDataGateway userDataGateway = (UserDataGateway) ctx.getBean("userDataGateway");
    final static BoardDataGateway boardDataGateway = (BoardDataGateway) ctx.getBean("boardDataGateway");
    final static PinDataGateway pinDataGateway = (PinDataGateway) ctx.getBean("pinDataGateway");


    /**
     * Í þessu falli eru týndir til allir pinnar sem fylgja þeim notendum
     * sem innskráður notandi fylgir.
     * @return listi af pinnum sem birtast á userhome innskráðs notanda
     */
    public static Result userhome() {
        String user = session("username");
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
        String user = session("username");
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
            Board board = pinService.getBoard(session().get("username"), filledForm.field("boardName").value());
            if(null == board){
                return unauthorized("Board does not exist ");
            }
            pinDataGateway.add(created,  board.getName(), session().get("username"));

            return ok(pinsummary.render(created));
        }
    }

    /**
     * boardname fallið sér um að birta lista af öllum pinnum tengdum
     * ákveðunum borðum
     * @param boardName
     * @return  Listi af pinnum á ákveðnu borði
     */
    public static Result getBoard(String boardName) {
        String user = session("username");
        if (user != null) {
            userService.setUserDataGateway(userDataGateway);
            List<Pin> pins = new ArrayList<Pin>();
            List<String> followers = userDataGateway.getFollowers(session().get("username"));
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
