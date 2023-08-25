package com.demoblaze.challenge.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

import static com.demoblaze.challenge.userinterfaces.StaticMenu.*;
import static com.demoblaze.challenge.utils.Wait.stopExecution;
import static com.demoblaze.challenge.utils.enums.MainMenu.HOME;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProductToCart implements Interaction {
    private final String productName;

    public AddProductToCart(String productName) {
        this.productName = productName;
    }

    public static AddProductToCart whoseNameIs(String productName) {
        return instrumented(AddProductToCart.class, productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        PRODUCT_CARD.of(productName).resolveFor(actor).setImplicitTimeout(Duration.ofSeconds(2));
        actor.attemptsTo(
                Check.whether(!PRODUCT_CARD.of(productName).resolveFor(actor).isCurrentlyVisible())
                        .andIfSo(Click.on(NEXT_BUTTON)),
                Click.on(PRODUCT_CARD.of(productName)),
                RememberProductPrice.fromProductDetails(),
                Click.on(ADD_TO_CART_BUTTON));

        stopExecution(2000);
        BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
        actor.attemptsTo(SelectStaticMenuOption.withText(HOME.getValue()));
    }
}
