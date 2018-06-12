package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.core.util.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.login.SalesForceLogIn;

import org.testng.Assert;

import static org.fundacionjala.core.util.CommonWebActions.resetWaitTime;
import static org.fundacionjala.core.util.CommonWebActions.waitTime;

/**
 * LogInSteps.java.
 * Class for steps logIn.feature.
 */
public class LogInSteps {

    private SalesForceLogIn login;

    /**
     * Given step.
     */
    @Given("^I login as a User")
    public void iLoginAsUser() {
        PropertiesManager prop = PropertiesManager.getInstance();
        login = new SalesForceLogIn(prop.getUrlLogin());
        login.logIn(prop.getUsername(), prop.getPassword(), prop.getTheme());
    }

    /**
     * Then step.
     */
    @Then("^Home Page should be displayed$")
    public void homePageShouldBeDisplated() {
        waitTime(2);
        Assert.assertTrue(login.getCloudIcon());
        resetWaitTime();
    }

}
