package com.demoblaze.challenge.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentForm {
    public static final Target PAYMENT_DETAILS_PARAGRAPH =
            Target.the("Payment details paragraph")
                    .located(By.xpath("//div[contains(@class, 'sweet-alert')]/p"));
}
