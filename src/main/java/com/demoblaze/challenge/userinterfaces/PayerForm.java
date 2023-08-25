package com.demoblaze.challenge.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PayerForm {
  public static final Target PAYER_NAME = Target.the("Payer name").located(By.id("name"));

  public static final Target COUNTRY = Target.the("Country").located(By.id("country"));

  public static final Target CITY = Target.the("City").located(By.id("city"));

  public static final Target CREDIT_CARD_NUMBER =
      Target.the("Credit card number").located(By.id("card"));

  public static final Target CREDIT_CARD_EXPIRATION_YEAR =
      Target.the("Credit card expiration year").located(By.id("year"));

  public static final Target CREDIT_CARD_EXPIRATION_MONTH =
      Target.the("Credit card expiration month").located(By.id("month"));

  public static final Target PURCHASE_BUTTON =
      Target.the("Purchase button").located(By.xpath("//button[text()='Purchase']"));
}
