package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.Opportunities.SFOpportunitiesHome;
import org.fundacionjala.sfdc.pageobjects.Opportunities.SFOpportunityPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

/**
 * Class for steps of deleteOpportunity.feature.
 */
public class DeleteOpportunitySteps {
    private WebDriver webDriver;
    private SFOpportunitiesHome SFOpportunitiesHome;
    private Properties propertiesManager;
    private SFOpportunityPage SFOpportunityPage;

    /**
     * When step.
     */
    @When("^I delete the opportunity created$")
    public void iDeleteTheOpportunityCreated() {
        webDriver = DriverManager.getInstance().getNavigator();
        SFOpportunitiesHome = new SFOpportunitiesHome(webDriver);
        SFOpportunityPage = SFOpportunitiesHome.deleteLastOpportunity();
        SFOpportunityPage.deleteOpportunity();
    }

    /**
     * Then step.
     */
    @Then("^the opportunity is deleted$")
    public void theOpportunityIsDeleted() {
        propertiesManager = PropertiesManager.getInstance().getConfig();
        Assert.assertNotEquals(SFOpportunitiesHome.getLastOpportunity(), propertiesManager.getProperty("opportunityName"));
    }
}
