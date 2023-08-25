package com.demoblaze.challenge.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectStaticMenuOption implements Interaction {
    private final String text;

    public SelectStaticMenuOption(String text) {
        this.text = text;
    }

    public static SelectStaticMenuOption withText(String text) {
        return instrumented(SelectStaticMenuOption.class, text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        STATIC_MENU.of(text).resolveFor(actor).waitUntilClickable().click();
    }
}
