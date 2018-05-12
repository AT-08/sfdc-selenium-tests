package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceAccounts;
import org.fundacionjala.sfdc.pageobjects.SalesForceMainTabClassic;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.Properties;

/**
 * AccountSteps.java
 * Class for steps of account.feature.
 */
public class AccountSteps {
    private WebDriver webDriver;

    private SalesForceAccounts salesForceAccounts;
    private Properties propertiesManager;

    /**
     * Given step.
     */
    @Given("^Go to accounts section$")
    public void goToAccountsSection() {
        System.out.println("This Step goes to accounts section");
        webDriver = DriverManager.getInstance().getNavigator();
        SalesForceMainTabClassic salesForceMainTab;
        salesForceMainTab = new SalesForceMainTabClassic(webDriver, "a.accountBlock", "li#AllTab_Tab");
        salesForceMainTab.displayOptions();
        salesForceMainTab.goToAccounts();
    }

    /**
     * When step.
     */
    @When("^I press new account button a new account form is displayed$")
    public void iPressNewAccountButtonANewAccountFormIsDisplayed() {
        System.out.println("This Step presses new account button");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        Assert.assertTrue(salesForceAccounts.isNewAccountButtonDisplayed());
    }

    /**
     * And step.
     */
    @And("^I fill the account name field and press the save button$")
    public void iFillTheAccountNameFieldAndPressTheSaveButton() {
        System.out.println("This Step fills account name field");
        webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        salesForceAccounts.createNewAccount(propertiesManager.getProperty("accountName"));
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
     * When step.
     */

    @When("^I choose an account from recent accounts and I click on Edit account$")
    public void iChooseAnAccountFromRecentAccountsAndIClickOnEditAccount() {
        System.out.println("Choose last account");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceAccounts = new SalesForceAccounts(webDriver);
//        String param = propertiesManager.getProperty("accountView");
        //salesForceAccounts.chooseAccounts(param, salesForceAccounts.getGoButton());
        salesForceAccounts.clickAccountNameLink();
        salesForceAccounts.clickEditAccount();
    }
    /**
     * When step.
     */
    @When("^I choose an account from recent accounts and I click on Delete account$")
    public void iChooseAnAccountFromRecentAccountsAndIClickOnDeleteAccount() {
        System.out.println("Choose last account");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceAccounts = new SalesForceAccounts(webDriver);
      //  String param = propertiesManager.getProperty("accountView");
       // salesForceAccounts.chooseAccounts(param, salesForceAccounts.getGoButton());
        salesForceAccounts.clickAccountNameLink();
        salesForceAccounts.clickDeleteAccount();
    }


    /**
     * Then step.
     */
    @And("^I click on OK$")
    public void iClickOnOK() {
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        salesForceAccounts.clickDeleteAlert();
    }

    /**
     * And step.
     */
    @And("^I edit the account name field and I press the save button$")
    public void iEditTheAccountNameFieldAndIPressTheSaveButton() {
        System.out.println("This Step edits account name field");
        webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        salesForceAccounts.editAccount(propertiesManager.getProperty("accountName"));
        salesForceAccounts.clickSaveNewAccountButton(salesForceAccounts.getSaveNewAccountButton());
    }

    /**
     * Then step.
     */
    @Then("^the system delete the account$")
    public void theSystemDeleteTheAccount() {
        webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        System.out.println("This Step tests verified id the account:");
        Assert.assertEquals(salesForceAccounts.accountHomePage(), "Home");
    }
}
