package com.demoblaze.challenge.tasks;

import com.demoblaze.challenge.models.Payer;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.demoblaze.challenge.userinterfaces.PayerForm.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillOutPayerInformation implements Task {
    private final Payer payer;

    public FillOutPayerInformation(Payer payer) {
        this.payer = payer;
    }

    public static FillOutPayerInformation withStandardInformation() {
        return instrumented(
                FillOutPayerInformation.class,
                new Payer("Standard user", "Medellín", "Colombia", "4242424242", "09", "2036"));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(payer.getName()).into(PAYER_NAME),
                Enter.theValue(payer.getCountry()).into(COUNTRY),
                Enter.theValue(payer.getCity()).into(CITY),
                Enter.theValue(payer.getCreditCardNumber()).into(CREDIT_CARD_NUMBER),
                Enter.theValue(payer.getCreditCardExpirationMonth()).into(CREDIT_CARD_EXPIRATION_MONTH),
                Enter.theValue(payer.getCreditCardExpirationYear()).into(CREDIT_CARD_EXPIRATION_YEAR),
                Click.on(PURCHASE_BUTTON));
    }
}

