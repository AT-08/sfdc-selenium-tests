package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.Opportunities.SFOEdit;
import org.fundacionjala.sfdc.pageobjects.Opportunities.SFOHome;
import org.fundacionjala.sfdc.pageobjects.Opportunities.SFOMainPage;
import org.fundacionjala.sfdc.pageobjects.SalesForceMainTabClassic;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

/**
 * Class for steps of createOpportunity.feature.
 */
public class OpportunitySteps {
    private SFOHome opportunitiesHome;
    private SFOEdit editOpportunity;
    private SFOMainPage opportunityOptionsPage;
    private Properties propertiesManager;

    /**
     * Given step.
     */
    @Given("^Go to opportunities section$")
    public void goToOpportunitiesSection() {
        SalesForceMainTabClassic salesForceMainTab;
        salesForceMainTab = new SalesForceMainTabClassic("a.opportunityBlock", "li#AllTab_Tab");
        salesForceMainTab.displayOptions();
        salesForceMainTab.goToAccounts();
    }

    /**
     * When step.
     */
    @When("^I fill the required fields in the new opportunity form$")
    public void iFillTheRequiredFieldsInTheNewOpportunityForm() {
        opportunitiesHome = new SFOHome();
        editOpportunity = new SFOEdit();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        opportunitiesHome.clickNewOpportunity();
        editOpportunity.editOpportunity(propertiesManager.getProperty("opportunityName"), propertiesManager.getProperty("opportunityCloseDate"), propertiesManager.getProperty("opportunityStage"));
        editOpportunity.clickSaveOpportunityButton();
    }

    /**
     * Then step.
     */
    @Then("^a new opportunity is created$")
    public void aNewOpportunityIsCreated() {
        opportunitiesHome = new SFOHome();
        editOpportunity = new SFOEdit();
        editOpportunity.goToOpportunitiesPage();
        Assert.assertEquals(opportunitiesHome.getLastOpportunity(), propertiesManager.getProperty("opportunityName"));
    }

    /**
     * Given step.
     */
    @Given("^Select the opportunity created$")
    public void selectTheOpportunityCreated() {
        opportunitiesHome = new SFOHome();
        opportunityOptionsPage = new SFOMainPage();
        opportunitiesHome.goToLastOpportunityPage();
        opportunityOptionsPage.clickEditOpportunity();
    }

    /**
     * When step.
     */
    @When("^I edit the fields filled in the opportunity form$")
    public void iEditTheFieldsFilledInTheOpportunityForm() {
        editOpportunity = new SFOEdit();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        editOpportunity.editOpportunity(propertiesManager.getProperty("editOpportunityName"), propertiesManager.getProperty("editOpportunityCloseDate"), propertiesManager.getProperty("editOpportunityStage"));
        editOpportunity.clickSaveOpportunityButton();
    }

    /**
     * Then step.
     */
    @Then("^the opportunity is modified$")
    public void theOpportunityIsModified() {
        opportunitiesHome = new SFOHome();
        editOpportunity = new SFOEdit();
        editOpportunity.goToOpportunitiesPage();
        Assert.assertEquals(opportunitiesHome.getLastOpportunity(), propertiesManager.getProperty("editOpportunityName"));
    }

    /**
     * When step.
     */
    @When("^I delete the opportunity created$")
    public void iDeleteTheOpportunityCreated() {
        opportunitiesHome = new SFOHome();
        opportunityOptionsPage = new SFOMainPage();
        opportunitiesHome.goToLastOpportunityPage();
        opportunityOptionsPage.deleteOpportunity();
    }

    /**
     * Then step.
     */
    @Then("^the opportunity is deleted$")
    public void theOpportunityIsDeleted() {
        opportunitiesHome = new SFOHome();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        Assert.assertNotEquals(opportunitiesHome.getLastOpportunity(), propertiesManager.getProperty("opportunityName"));
    }
}
