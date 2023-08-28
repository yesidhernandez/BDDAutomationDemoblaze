package com.demoblaze.challenge.tasks;

import static com.demoblaze.challenge.userinterfaces.StaticMenu.*;
import static com.demoblaze.challenge.utils.enums.EnvironmentVariables.DEMOBLAZE_PASSWORD;
import static com.demoblaze.challenge.utils.enums.EnvironmentVariables.DEMOBLAZE_USERNAME;
import static com.demoblaze.challenge.utils.enums.MainMenu.LOG_IN;
import static net.serenitybdd.core.environment.ConfiguredEnvironment.getEnvironmentVariables;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.demoblaze.challenge.interactions.SelectStaticMenuOption;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class AuthenticateToDemoblaze implements Task {
  private final String username;
  private final String password;

  public AuthenticateToDemoblaze() {
    username =
        EnvironmentSpecificConfiguration.from(getEnvironmentVariables())
            .getProperty(DEMOBLAZE_USERNAME.getEnvironmentVariable());
    password =
        EnvironmentSpecificConfiguration.from(getEnvironmentVariables())
            .getProperty(DEMOBLAZE_PASSWORD.getEnvironmentVariable());
  }

  public static AuthenticateToDemoblaze usingCredentialsDefinedAsEnvironmentVariables() {
    return instrumented(AuthenticateToDemoblaze.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SelectStaticMenuOption.withText(LOG_IN.getValue()),
        WaitUntil.the(LOGIN_MODAL, isVisible()),
        Enter.theValue(username).into(LOGIN_USERNAME),
        Enter.theValue(password).into(LOGIN_PASSWORD),
        Click.on(LOGIN_BUTTON));
  }
}
