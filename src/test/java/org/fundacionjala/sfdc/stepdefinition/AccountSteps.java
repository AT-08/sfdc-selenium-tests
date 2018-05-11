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
        salesForceMainTab = new SalesForceMainTabClassic(webDriver, "Accounts", "li[id='AllTab_tab']");
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
     * When step.
     */
    @When("^I choose all accounts$")
    public void iChooseAllAccounts() {
        System.out.println("Choose all accounts from list");
        webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        String param = propertiesManager.getProperty("accountView");
        salesForceAccounts.chooseAccounts(param, salesForceAccounts.getGoButton());
    }

    /**
     * Then step.
     */
    @Then("^A list of accounts is displayed$")
    public void aListOfAccountsIsDisplayed() {
        System.out.println("Accounts are displayed");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        propertiesManager = PropertiesManager.getInstance().getConfig();
        String actual = salesForceAccounts.isAllAccountsSelected(propertiesManager.getProperty("accountView"));
        Assert.assertEquals("All Accounts", actual);

    }

    @When("^I choose an account from recent accounts$")
    public void iChooseAnAccountFromRecentAccounts() throws Throwable {
        System.out.println("Choose last account");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        salesForceAccounts.clickAccountNameLink();
    }

    @Then("^I click on Delete account$")
    public void iClickOnDeleteAccount() throws Throwable {
        System.out.println("Choose delete button");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        salesForceAccounts.clickDeleteAccount();
    }

    @And("^I click on OK$")
    public void iClickOnOK() throws Throwable {
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        salesForceAccounts.clickDeleteAlert();
    }

    @Then("^I click on Edit account$")
    public void iClickOnEditAccount() throws Throwable {
        System.out.println("Choose edit button");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        salesForceAccounts.clickEditAccount();
    }

    @Then("^I edit the account name field$")
    public void iEditTheAccountNameField() throws Throwable {
        System.out.println("This Step edits account name field");
        webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceAccounts = new SalesForceAccounts(webDriver);
        salesForceAccounts.editAccount(propertiesManager.getProperty("accountName"));
    }
}
