package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceOpportunitiesHome;
import org.fundacionjala.sfdc.pageobjects.SalesForceOpportunityPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

public class DeleteOpportunitySteps {
    private WebDriver webDriver;
    private SalesForceOpportunitiesHome salesForceOpportunitiesHome;
    private Properties propertiesManager;
    private SalesForceOpportunityPage salesForceOpportunityPage;

    /**
     * Given step.
     */
    @When("^I delete the opportunity created$")
    public void iDeleteTheOpportunityCreated() {
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceOpportunitiesHome = new SalesForceOpportunitiesHome(webDriver);
        salesForceOpportunityPage = salesForceOpportunitiesHome.deleteLastOpportunity();
        salesForceOpportunityPage.deleteOpportunity();
    }

    /**
     * Then step.
     */
    @Then("^the opportunity is deleted$")
    public void theOpportunityIsDeleted() {
        propertiesManager = PropertiesManager.getInstance().getConfig();
        Assert.assertNotEquals(salesForceOpportunitiesHome.getLastOpportunity(), propertiesManager.getProperty("opportunityName"));
    }
}
