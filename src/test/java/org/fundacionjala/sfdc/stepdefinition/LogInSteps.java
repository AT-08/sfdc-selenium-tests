package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import org.fundacionjala.core.ui.CommonWebActions;
import org.fundacionjala.core.util.PropertiesInput;
import org.fundacionjala.core.util.PropertiesManager;
import org.fundacionjala.sfdc.pages.login.SalesForceLogIn;
import org.fundacionjala.sfdc.util.PropertiesSalesForce;

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
        PropertiesSalesForce prop = PropertiesSalesForce.getInstance();
        login = new SalesForceLogIn(PropertiesManager.getInstance().getProperties(PropertiesInput.URL_LOGIN));
        login.logIn(PropertiesManager.getInstance().getProperties(PropertiesInput.USER), PropertiesManager
                .getInstance().getProperties(PropertiesInput.PASSWORD), prop.getTheme());
    }

    /**
     * Then step.
     */
    @Then("^Home Page should be displayed$")
    public void homePageShouldBeDisplayed() {
        try {
            CommonWebActions.waitTime(2);
            Assert.assertTrue(login.getCloudIcon());
        } finally {
            CommonWebActions.resetWaitTime();
        }
    }

}
