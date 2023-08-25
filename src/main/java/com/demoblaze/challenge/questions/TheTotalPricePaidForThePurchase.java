package com.demoblaze.challenge.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.demoblaze.challenge.userinterfaces.PaymentForm.PAYMENT_DETAILS_PARAGRAPH;
import static com.demoblaze.challenge.utils.StringFormats.removeLettersAndSpecialCharacters;
import static com.demoblaze.challenge.utils.enums.StringConstants.*;

public class TheTotalPricePaidForThePurchase implements Question<Integer> {
    public static TheTotalPricePaidForThePurchase is() {
        return new TheTotalPricePaidForThePurchase();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        final String amount = "Amount";
        String valueToEvaluate = EMPTY_TEXT_STRING.getValue();
        String paymentDetailsParagraph = PAYMENT_DETAILS_PARAGRAPH.resolveFor(actor).getText();

        String[] paragraphLines = paymentDetailsParagraph.split(LINE_BREAK.getValue());

        for (String paragraphLine : paragraphLines) {
            if (paragraphLine.startsWith(amount)) {
                String[] lineToEvaluate = paragraphLine.split(COLON.getValue());
                valueToEvaluate = removeLettersAndSpecialCharacters(lineToEvaluate[1]);
                break;
            }
        }

        return Integer.parseInt(valueToEvaluate);
    }
}
