package org.fundacionjala.sfdc.stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageObjects.SalesForceAccounts;
import org.fundacionjala.sfdc.pageObjects.SalesForceMainTab;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.Properties;

/**
 * AccountSteps.java
 * Class for steps of account.feature.
 */
public class AccountSteps {
    private WebDriver webDriver;
    private SalesForceMainTab salesForceMainTab;
    private SalesForceAccounts salesForceAccounts;
    private Properties propertiesManager;

    /**
     * Given step.
     */
    @Given("^Go to accounts section$")
    public void goToAccountsSection() {
        System.out.println("This Step goes to accounts section");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceMainTab = new SalesForceMainTab(webDriver);
        salesForceMainTab.displayOptions();
        salesForceMainTab.goToAccounts();
    }

    /**
     * When step.
     */
    @When("^I press new account button$")
    public void iPressNewAccountButton() {
        System.out.println("This Step presses new account button");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceAccounts = new SalesForceAccounts(webDriver);
    }

    /**
     * Then step.
     */
    @Then("^new account form is displayed$")
    public void newAccountFormIsDisplayed() {
        System.out.println("This Step displays new accounts form");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        Assert.assertTrue(salesForceAccounts.isNewAccountButtonDisplayed());
    }

    /**
     * Then step.
     */
    @Then("^I fill the account name field$")
    public void iFillTheAccountNameField() {
        System.out.println("This Step fills account name field");
        webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        salesForceAccounts.createNewAccount(propertiesManager.getProperty("accountName"));
    }

    /**
     * And step.
     */
    @And("^press the save button$")
    public void pressTheSaveButton() {
        System.out.println("This Step saves new account");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        salesForceAccounts.clickSaveNewAccountButton(salesForceAccounts.getSaveNewAccountButton());
    }

    /**
     * Then step.
     */
    @Then("^a new account is created$")
    public void aNewAccountIsCreated() {
        webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        System.out.println("This Step tests new account creation:" + salesForceAccounts.newAccountSavedName());
        Assert.assertEquals(salesForceAccounts.newAccountSavedName(), propertiesManager.getProperty("accountName"));
    }

    /**
     * After, to close browser after the tests is executed.
     */
    @After
    public void closeBrowser() {
        System.out.println("This Step closes browser");
        webDriver = DriverManager.getInstance().getNavigator();
        webDriver.close();
    }

}
