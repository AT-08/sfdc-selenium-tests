package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceLogIn;
import org.testng.Assert;
import java.util.Properties;

/**
 * LogInSteps.java.
 * Class for steps logIn.feature.
 */
public class LogInSteps {

    private SalesForceLogIn login;

    /**
     * Given step.
     */
    @Given("^Open the Firefox and launch the application enter the Username and Password and press login$")
    public void openTheFirefoxAndLaunchTheApplicationEnterTheUsernameAndPasswordAndPressLogin() {
        System.out.println("Open Browser and go to login page of the SalesForce and fill the username and password.");
        login = new SalesForceLogIn("https://login.salesforce.com/");
        Properties prop = PropertiesManager.getInstance().getConfig();
        login.logIn(prop.getProperty("user"), prop.getProperty("password"));
    }

    /**
     * Then step.
     */
    @Then("^I login to the application$")
    public void iLoginToTheApplication() {
        System.out.println("Click login.");
        Assert.assertTrue(login.getCloudIcon());
    }

}
