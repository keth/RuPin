package controllers;

import play.mvc.*;

import views.html.*;

public class Application extends RuPinController
{
  public static Result index()
  {

    return ok(index.render());
  }


}