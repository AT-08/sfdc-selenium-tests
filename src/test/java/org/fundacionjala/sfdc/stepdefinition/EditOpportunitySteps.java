package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.Opportunities.SFEditOpportunity;
import org.fundacionjala.sfdc.pageobjects.Opportunities.SFOpportunitiesHome;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

/**
 * Class for steps of editOpportunity.feature.
 */
public class EditOpportunitySteps {
    private WebDriver webDriver;
    private SFOpportunitiesHome SFOpportunitiesHome;
    private Properties propertiesManager;
    private SFEditOpportunity editOpportunity;

    /**
     * Given step.
     */
    @Given("^Select the opportunity created$")
    public void selectTheOpportunityCreated() {
        webDriver = DriverManager.getInstance().getNavigator();
        SFOpportunitiesHome = new SFOpportunitiesHome(webDriver);
        editOpportunity = SFOpportunitiesHome.editLastOpportunity().editOpportunity();
    }

    /**
     * When step.
     */
    @When("^I edit the fields filled in the opportunity form$")
    public void iEditTheFieldsFilledInTheOpportunityForm() {
        propertiesManager = PropertiesManager.getInstance().getConfig();
        editOpportunity.editOpportunity(propertiesManager.getProperty("editOpportunityName"), propertiesManager.getProperty("editOpportunityCloseDate"), propertiesManager.getProperty("editOpportunityStage"));
    }

    /**
     * Then step.
     */
    @Then("^the opportunity is modified$")
    public void theOpportunityIsModified() {
        SFOpportunitiesHome = editOpportunity.goToOpportunitiesPage();
        Assert.assertEquals(SFOpportunitiesHome.getLastOpportunity(), propertiesManager.getProperty("editOpportunityName"));
    }
}
