package com.demoblaze.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectProductsForPurchase implements Task {
    private final List<Product> products;

    public SelectProductsForPurchase(List<Product> products) {
        this.products = products;
    }

    public static SelectProductsForPurchase withTheFollowingCharacteristics(List<Product> products) {
        return instrumented(SelectProductsForPurchase.class, products);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int totalPrice = 0;

        for (Product product : products) {
            actor.attemptsTo(
                    WaitUntil.the(CATEGORY.of(product.getCategory()), isClickable())
                            .then(Click.on(CATEGORY.of(product.getCategory()))),
                    AddProductToCart.whoseNameIs(product.getName()));
            totalPrice = totalPrice + Integer.parseInt(actor.recall(PRODUCT_PRICE.getValue()).toString());
        }

        actor.remember(FULL_PURCHASE_PRICE.getValue(), totalPrice);
    }
}
