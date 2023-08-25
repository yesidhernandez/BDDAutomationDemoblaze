package com.demoblaze.challenge.tasks;

import static com.demoblaze.challenge.userinterfaces.StaticMenu.PLACE_ORDER_BUTTON;
import static com.demoblaze.challenge.utils.enums.MainMenu.CART;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.demoblaze.challenge.interactions.SelectStaticMenuOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class PlaceOrder implements Task {
  public static PlaceOrder withPayerInformation() {
    return instrumented(PlaceOrder.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SelectStaticMenuOption.withText(CART.getValue()),
        Click.on(PLACE_ORDER_BUTTON),
        FillOutPayerInformation.withStandardInformation());
  }
}
