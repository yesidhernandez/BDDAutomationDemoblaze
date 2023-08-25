package com.demoblaze.challenge.stepdefinitions;

import com.demoblaze.challenge.models.Product;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;

import java.util.List;
import java.util.Map;

import static com.demoblaze.challenge.utils.enums.ActorNotepad.FULL_PURCHASE_PRICE;
import static com.demoblaze.challenge.utils.enums.Resources.DEMOBLAZE_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class DemoblazeStepDefinition {
    @DataTableType
    public Product productEntryTransformer(Map<String, String> data) {
        return new Product(data.get("category"), data.get("name"));
    }

    @Given("that {word} opens the demoblaze page in the browser")
    public void openDemoblazePage(String actor) {
        theActorCalled(actor).wasAbleTo(Open.url(DEMOBLAZE_URL.getValue()));
    }

    @Given("he/she/it accesses the demoblaze page with the following credentials")
    public void demoblazePageAuthentication(Map<String, String> credentials) {
        theActorInTheSpotlight().attemptsTo(AuthenticateToDemoblaze.withCredentials(credentials));
    }

    @When("he/she/it selects the following products for purchase")
    public void selectProductsToPurchase(List<Product> products) {
        theActorInTheSpotlight()
                .attemptsTo(SelectProductsForPurchase.withTheFollowingCharacteristics(products));
    }

    @When("he/she/it places the order")
    public void placeOrder() {
        theActorInTheSpotlight().attemptsTo(PlaceOrder.withPayerInformation());
    }

    @Then("he/she/it should see that the payment made corresponds to the value of the selected items")
    public void validateTotalPricePaid() {
        int fullPurchasePrice = theActorInTheSpotlight().recall(FULL_PURCHASE_PRICE.getValue());
        theActorInTheSpotlight()
                .should(
                        seeThat(TheTotalPricePaidForThePurchase.is(), equalTo(fullPurchasePrice))
                                .orComplainWith(UnexpectedValueError.class, WRONG_PRICE_ERROR.getMessage()));
    }
}
