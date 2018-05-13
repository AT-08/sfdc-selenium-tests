package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.Opportunities.SFEditOpportunity;
import org.fundacionjala.sfdc.pageobjects.Opportunities.SFOpportunitiesHome;
import org.fundacionjala.sfdc.pageobjects.SalesForceMainTabClassic;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

/**
 * Class for steps of createOpportunity.feature.
 */
public class CreateOpportunitySteps {
    private WebDriver webDriver;
    private SFOpportunitiesHome SFOpportunitiesHome;
    private Properties propertiesManager;
    private SFEditOpportunity newOpportunity;

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
        SFOpportunitiesHome = new SFOpportunitiesHome(webDriver);
        propertiesManager = PropertiesManager.getInstance().getConfig();
        newOpportunity = SFOpportunitiesHome.clickNewOpportunity();
        newOpportunity.editOpportunity(propertiesManager.getProperty("opportunityName"), propertiesManager.getProperty("opportunityCloseDate"), propertiesManager.getProperty("opportunityStage"));
    }

    /**
     * Then step.
     */
    @Then("^a new opportunity is created$")
    public void aNewOpportunityIsCreated() {
        SFOpportunitiesHome = newOpportunity.goToOpportunitiesPage();
        Assert.assertEquals(SFOpportunitiesHome.getLastOpportunity(), propertiesManager.getProperty("opportunityName"));
    }
}
