package com.demoblaze.challenge.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class StaticMenu {

    public static final Target STATIC_MENU =
            Target.the("Static menu {0} option")
                    .locatedBy("//div[@id='navbarExample']//li/a[text()='{0}']");

    public static final Target LOGIN_MODAL = Target.the("Login modal").located(By.id("logInModal"));

    public static final Target LOGIN_USERNAME =
            Target.the("Login username").located(By.id("loginusername"));

    public static final Target LOGIN_PASSWORD =
            Target.the("Login password").located(By.id("loginpassword"));

    public static final Target LOGIN_BUTTON =
            Target.the("Login button")
                    .located(
                            By.xpath(
                                    "//div[@id='logInModal']//div[@class='modal-footer']/button[@onclick='logIn()']"));

    public static final Target CATEGORY =
            Target.the("{0} category")
                    .locatedBy("//div[@class='list-group']/*[@id='itemc' and text()='{0}']");

    public static final Target PRODUCT_CARD =
            Target.the("{0} card")
                    .locatedBy("//div[@id='tbodyid']//div[@class='card-block']//a[text()='{0}']");

    public static final Target PRICE_CONTAINER =
            Target.the("Price container").located(By.xpath("//*[@class='price-container']"));

    public static final Target ADD_TO_CART_BUTTON =
            Target.the("Add to cart button").located(By.xpath("//a[text()='Add to cart']"));

    public static final Target NEXT_BUTTON = Target.the("Next button").located(By.id("next2"));

    public static final Target PLACE_ORDER_BUTTON =
            Target.the("Place order button").located(By.xpath("//button[text()='Place Order']"));
}
