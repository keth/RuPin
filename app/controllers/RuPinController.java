package controllers;

import is.ru.honn.rupin.domain.Pin;
import is.ru.honn.rupin.service.PinService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.List;

public class RuPinController extends Controller
{
  protected static ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/ApplicationContext.xml");




    public static Result getPins() {

        PinService pinService = (PinService) ctx.getBean("PinService");
        List<Pin> pins = pinService.getPinsOnBoard("qwe", "qwe");

      //  return ok(login.render((Pin) pins));
        return ok(index.render());
    }



}
