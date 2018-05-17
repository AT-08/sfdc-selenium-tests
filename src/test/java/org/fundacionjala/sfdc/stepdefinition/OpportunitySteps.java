package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.opportunities.SFOEdit;
import org.fundacionjala.sfdc.pageobjects.opportunities.SFOHome;
import org.fundacionjala.sfdc.pageobjects.opportunities.SFOMainPage;
import org.fundacionjala.sfdc.pageobjects.SalesForceMainTabClassic;
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

    private static final String OP_NAME = "opportunityName";

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
        opportunitiesHome = new SFOHome() {
        };
        editOpportunity = new SFOEdit();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        opportunitiesHome.clickNewOpportunity();
        final String opName = propertiesManager.getProperty(OP_NAME);
        final String opCloseDate = propertiesManager.getProperty("opportunityCloseDate");
        final String opStage = propertiesManager.getProperty("opportunityStage");
        editOpportunity.editOpportunity(opName, opCloseDate, opStage);
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
        Assert.assertEquals(opportunitiesHome.getLastOpportunity(), propertiesManager.getProperty(OP_NAME));
    }

    /**
     * Given step.
     */
    @Given("^Select the opportunity created$")
    public void selectTheOpportunityCreated() {
        opportunitiesHome = new SFOHome();
        opportunityOptionsPage = new SFOMainPage() {
        };
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
        final String editOpName = propertiesManager.getProperty("editOpportunityName");
        final String editOpCloseName = propertiesManager.getProperty("editOpportunityCloseDate");
        final String editOpStage = propertiesManager.getProperty("editOpportunityStage");
        editOpportunity.editOpportunity(editOpName, editOpCloseName, editOpStage);
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
        final String editOpName = propertiesManager.getProperty("editOpportunityName");
        Assert.assertEquals(opportunitiesHome.getLastOpportunity(), editOpName);
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
        final String opName = propertiesManager.getProperty(OP_NAME);
        Assert.assertNotEquals(opportunitiesHome.getLastOpportunity(), opName);
    }
}
