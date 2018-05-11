package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
//import org.fundacionjala.sfdc.pageobjects.SalesForceMainTab;
import org.fundacionjala.sfdc.pageobjects.SalesForceMainTabClassic;
import org.fundacionjala.sfdc.pageobjects.SalesForceOpportunities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

/**
 * AccountSteps.java
 * Class for steps of account.feature.
 */
public class OpportunitySteps {
    private WebDriver webDriver;
    private SalesForceOpportunities salesForceOpportunities;
    private Properties propertiesManager;

    /**
     * Given step.
     */
    @Given("^Go to opportunities section$")
    public void goToOpportunitiesSection() {
        System.out.println("This Step goes to opportunities section");
        webDriver = DriverManager.getInstance().getNavigator();
        SalesForceMainTabClassic salesForceMainTab;
        salesForceMainTab = new SalesForceMainTabClassic(webDriver, "Opportunities", "li[id='AllTab_tab']");
        salesForceMainTab.displayOptions();
        salesForceMainTab.goToAccounts();
    }

    /**
     * When step.
     */
    @When("^I fill the required fields in the new opportunity form$")
    public void iFillTheRequiredFieldsInTheNewOpportunityForm() {
        System.out.println("This Step creates a new opportunity");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceOpportunities = new SalesForceOpportunities(webDriver);
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceOpportunities.createNewOpportunity(propertiesManager.getProperty("opportunityName"), propertiesManager.getProperty("opportunityCloseDate"), propertiesManager.getProperty("opportunityStage"));
        salesForceOpportunities.clickNewOpportunityButton(salesForceOpportunities.getSaveNewOpportunityButton());
    }

    /**
     * When step.
     */
    @And("^a new opportunity is created$")
    public void aNewOpportunityIsCreated() {
        System.out.println("This Step creates a new opportunity");
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceOpportunities = new SalesForceOpportunities(webDriver);
        System.out.println("This Step tests new account creation:" + salesForceOpportunities.newOpportunitySavedName());
        Assert.assertEquals(salesForceOpportunities.newOpportunitySavedName(), propertiesManager.getProperty("opportunityName"));
    }

    /**
     * Then step.
     *//*
    @Then("^new account form is displayed$")
    public void newAccountFormIsDisplayed() {
        System.out.println("This Step displays new accounts form");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceOpportunities = new SalesForceOpportunities(webDriver);
        Assert.assertTrue(salesForceOpportunities.isNewOpportunityButtonDisplayed());
    }

    /**
     * Then step.
     *//*
    @Then("^I fill the account name field$")
    public void iFillTheAccountNameField() {
        System.out.println("This Step fills account name field");
        webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceOpportunities = new SalesForceOpportunities(webDriver);
        salesForceOpportunities.createNewOpportunity(propertiesManager.getProperty("accountName"));
    }

    /**
     * And step.
     *//*
    @And("^press the save button$")
    public void pressTheSaveButton() {
        System.out.println("This Step saves new account");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceOpportunities = new SalesForceOpportunities(webDriver);
        salesForceOpportunities.clickSaveNewOpportunityButton(salesForceOpportunities.getSaveNewOpportunityButton());
    }

    /**
     * Then step.
     *//*
    @Then("^a new account is created$")
    public void aNewAccountIsCreated() {
        webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceOpportunities = new SalesForceOpportunities(webDriver);
        System.out.println("This Step tests new account creation:" + salesForceOpportunities.newOpportunitySavedName());
        Assert.assertEquals(salesForceOpportunities.newOpportunitySavedName(), propertiesManager.getProperty("accountName"));
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

    /**
     * When step.
     *//*
    @When("^I choose all accounts$")
    public void iChooseAllAccounts() {
        System.out.println("Choose all accounts from list");
        webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceOpportunities = new SalesForceOpportunities(webDriver);
        String param = propertiesManager.getProperty("accountView");
        salesForceOpportunities.chooseOpportunity(param, salesForceOpportunities.getGoButton());
    }

    /**
     * Then step.
     *//*
    @Then("^A list of accounts is displayed$")
    public void aListOfAccountsIsDisplayed() {
        System.out.println("Accounts are displayed");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceOpportunities = new SalesForceOpportunities(webDriver);
        propertiesManager = PropertiesManager.getInstance().getConfig();
        String actual = salesForceOpportunities.isAllAccountsSelected(propertiesManager.getProperty("accountView"));
        Assert.assertEquals("All Accounts", actual);

    }*/

    /**
     * And step.
     *//*
    @And("^I click on edit link$")
    public void iClickOnEditLink() {
        System.out.println("Choose and edit an account");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceOpportunities = new SalesForceOpportunities(webDriver);
        // salesForceOpportunities.editOpportunity();
    }*/
}
