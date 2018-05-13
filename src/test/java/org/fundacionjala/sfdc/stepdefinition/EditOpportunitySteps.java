package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceEditOpportunity;
import org.fundacionjala.sfdc.pageobjects.SalesForceOpportunitiesHome;
import org.fundacionjala.sfdc.pageobjects.SalesForceOpportunityPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

public class EditOpportunitySteps {
    private WebDriver webDriver;
    private SalesForceOpportunitiesHome salesForceOpportunitiesHome;
    private Properties propertiesManager;
    private SalesForceEditOpportunity editOpportunity;

    /**
     * Given step.
     */
    @Given("^Select the opportunity created$")
    public void selectTheOpportunityCreated() {
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceOpportunitiesHome = new SalesForceOpportunitiesHome(webDriver);
        editOpportunity = salesForceOpportunitiesHome.editLastOpportunity().editOpportunity();
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
     * And step.
     */
    @Then("^the opportunity is modified$")
    public void theOpportunityIsModified() {
        salesForceOpportunitiesHome = editOpportunity.goToOpportunitiesPage();
        Assert.assertEquals(salesForceOpportunitiesHome.getLastOpportunity(), propertiesManager.getProperty("editOpportunityName"));
    }
}
