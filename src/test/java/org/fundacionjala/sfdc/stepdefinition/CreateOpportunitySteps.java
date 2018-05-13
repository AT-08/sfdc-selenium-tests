package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceEditOpportunity;
import org.fundacionjala.sfdc.pageobjects.SalesForceOpportunitiesHome;
import org.fundacionjala.sfdc.pageobjects.SalesForceMainTabClassic;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

/**
 * AccountSteps.java
 * Class for steps of account.feature.
 */
public class CreateOpportunitySteps {
    private WebDriver webDriver;
    private SalesForceOpportunitiesHome salesForceOpportunitiesHome;
    private Properties propertiesManager;
    private SalesForceEditOpportunity newOpportunity;

    /**
     * Given step.
     */
    @Given("^Go to opportunities section$")
    public void goToOpportunitiesSection() {
        webDriver = DriverManager.getInstance().getNavigator();
        SalesForceMainTabClassic salesForceMainTab;
        salesForceMainTab = new SalesForceMainTabClassic(webDriver, "a.opportunityBlock", "li#AllTab_Tab");
        salesForceMainTab.displayOptions();
        salesForceMainTab.goToAccounts();
    }

    /**
     * When step.
     */
    @When("^I fill the required fields in the new opportunity form$")
    public void iFillTheRequiredFieldsInTheNewOpportunityForm() {
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceOpportunitiesHome = new SalesForceOpportunitiesHome(webDriver);
        propertiesManager = PropertiesManager.getInstance().getConfig();
        newOpportunity = salesForceOpportunitiesHome.clickNewOpportunity();
        newOpportunity.editOpportunity(propertiesManager.getProperty("opportunityName"), propertiesManager.getProperty("opportunityCloseDate"), propertiesManager.getProperty("opportunityStage"));
    }

    /**
     * And step.
     */
    @Then("^a new opportunity is created$")
    public void aNewOpportunityIsCreated() {
        salesForceOpportunitiesHome = newOpportunity.goToOpportunitiesPage();
        Assert.assertEquals(salesForceOpportunitiesHome.getLastOpportunity(), propertiesManager.getProperty("opportunityName"));
    }
}
