package com.demoblaze.challenge.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static com.demoblaze.challenge.userinterfaces.StaticMenu.PRICE_CONTAINER;
import static com.demoblaze.challenge.utils.StringFormats.removeLettersAndSpecialCharacters;
import static com.demoblaze.challenge.utils.enums.ActorNotepad.PRODUCT_PRICE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RememberProductPrice implements Interaction {
    public static RememberProductPrice fromProductDetails() {
        return instrumented(RememberProductPrice.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(
                PRODUCT_PRICE.getValue(),
                removeLettersAndSpecialCharacters(PRICE_CONTAINER.resolveFor(actor).getText()));
    }
}
