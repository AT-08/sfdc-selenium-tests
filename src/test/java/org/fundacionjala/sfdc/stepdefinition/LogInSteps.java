package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceLogIn;

import org.testng.Assert;

/**
 * LogInSteps.java.
 * Class for steps logIn.feature.
 */
public class LogInSteps {

    private SalesForceLogIn login;

    /**
     * Given step.
     */
    @Given("^Open Browser and launch the application enter the Username and Password and press login$")
    public void openTheFirefoxAndLaunchTheApplicationEnterTheUsernameAndPasswordAndPressLogin() {
        login = new SalesForceLogIn("https://login.salesforce.com/");
        PropertiesManager prop = PropertiesManager.getInstance();
        login.logIn(prop.getUsername(), prop.getPassword(), prop.getTheme());
    }

    /**
     * Then step.
     */
    @Then("^I login to the application$")
    public void iLoginToTheApplication() {
        Assert.assertTrue(login.getCloudIcon());
    }

}
