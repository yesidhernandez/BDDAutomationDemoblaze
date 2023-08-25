package com.demoblaze.challenge.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/buy_items_in_demoblaze.feature",
    glue = "com.demoblaze.challenge.stepdefinitions",
    snippets = CucumberOptions.SnippetType.CAMELCASE)
public class BuyItemsInDemoblazeRunner {}
