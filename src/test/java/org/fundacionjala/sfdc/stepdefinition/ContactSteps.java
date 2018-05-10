package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceContacts;
import org.fundacionjala.sfdc.pageobjects.SalesForceMainTabClassic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ContactSteps.java
 * Class for steps of account.feature.
 */
public class ContactSteps {
    private WebDriver webDriver;
    private SalesForceContacts salesForceContacts;


    /**
     * Given step.
     */
    @Given("^Go to contacts section$")
    public void goToContactsSection() {
        System.out.println("This Step goes to contacts section");
        webDriver = DriverManager.getInstance().getNavigator();
        SalesForceMainTabClassic salesForceMainTab;
        salesForceMainTab = new SalesForceMainTabClassic(webDriver, "a[title='Contacts']", "button.salesforceIdentityAppLauncherHeader");
        salesForceMainTab.displayOptions();

        salesForceMainTab.goToAccounts();

    }

    /**
     * When step.
     */
    @When("^I press new contacts button$")
    public void iPressNewContactsButton() {
        System.out.println("This Step presses new account button");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceContacts = new SalesForceContacts(webDriver);
        salesForceContacts.clickNewButton(salesForceContacts.getNewButton());
    }

    /**
     * Then step.
     */
    @Then("^new contacts form is displayed$")
    public void newContactsFormIsDisplayed() {
        System.out.println("This Step displays new accounts form");
       // webDriver = DriverManager.getInstance().getNavigator();
       // salesForceAccounts = new SalesForceAccounts(webDriver);
       // Assert.assertTrue(salesForceAccounts.isNewAccountButtonDisplayed());
    }

    /**
     * Then step.
     */
    @Then("^I fill the contacts name field$")
    public void iFillTheContactsNameField() {
        System.out.println("This Step fills account name field");
       // webDriver = DriverManager.getInstance().getNavigator();
      //  propertiesManager = PropertiesManager.getInstance().getConfig();
      //  salesForceAccounts = new SalesForceAccounts(webDriver);
      //  salesForceAccounts.createNewAccount(propertiesManager.getProperty("accountName"));
    }

    /**
     * And step.
     */
    @And("^press the save contact button$")
    public void pressTheSaveContactButton() {
        System.out.println("This Step saves new account");
     //   webDriver = DriverManager.getInstance().getNavigator();
     //   salesForceAccounts = new SalesForceAccounts(webDriver);
     //   salesForceAccounts.clickSaveNewAccountButton(salesForceAccounts.getSaveNewAccountButton());
    }

    /**
     * Then step.
     */
    @Then("^a new contact is created$")
    public void aNewContactIsCreated() {
       /* webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        System.out.println("This Step tests new account creation:" + salesForceAccounts.newAccountSavedName());
        Assert.assertEquals(salesForceAccounts.newAccountSavedName(), propertiesManager.getProperty("accountName"));*/
    }

    /**
     * After, to close browser after the tests are executed.
     */
    /*@After
    public void closeBrowser() {
        System.out.println("This Step closes browser");
        webDriver = DriverManager.getInstance().getNavigator();
        webDriver.close();
    }*/


}

