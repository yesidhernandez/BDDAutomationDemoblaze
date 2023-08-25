package com.demoblaze.challenge.tasks;

import static com.demoblaze.challenge.userinterfaces.StaticMenu.*;
import static com.demoblaze.challenge.utils.enums.MainMenu.LOG_IN;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.demoblaze.challenge.interactions.SelectStaticMenuOption;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class AuthenticateToDemoblaze implements Task {
  private final String user;
  private final String password;

  private static final String USER = "user";
  private static final String PASS = "password";

  public AuthenticateToDemoblaze(Map<String, String> credentials) {
    user = credentials.get(USER) == null ? "" : credentials.get(USER);
    password = credentials.get(PASS) == null ? "" : credentials.get(PASS);
  }

  public static AuthenticateToDemoblaze withCredentials(Map<String, String> credentials) {
    return instrumented(AuthenticateToDemoblaze.class, credentials);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SelectStaticMenuOption.withText(LOG_IN.getValue()),
        WaitUntil.the(LOGIN_MODAL, isVisible()),
        Enter.theValue(user).into(LOGIN_USERNAME),
        Enter.theValue(password).into(LOGIN_PASSWORD),
        Click.on(LOGIN_BUTTON));
  }
}
