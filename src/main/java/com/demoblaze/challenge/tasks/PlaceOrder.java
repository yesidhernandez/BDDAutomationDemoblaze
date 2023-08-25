package com.demoblaze.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

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
