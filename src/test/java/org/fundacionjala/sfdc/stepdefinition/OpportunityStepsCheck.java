package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.pageobjects.SalesForceTabClassic;
import org.fundacionjala.sfdc.pageobjects.opportunities.OpportInputs;
import org.fundacionjala.sfdc.pageobjects.opportunities.SFODetailsPage;
import org.fundacionjala.sfdc.pageobjects.opportunities.SFOMainPage;
import org.fundacionjala.sfdc.pageobjects.opportunities.SFONewModifyPage;
import org.testng.Assert;

import java.util.Map;

/**
 * OpportunityStepsCheck.
 */
public class OpportunityStepsCheck {

    private SalesForceTabClassic tabClassic = new SalesForceTabClassic();
    private SFOMainPage mainPage = new SFOMainPage();
    private SFONewModifyPage modifyPage = new SFONewModifyPage();
    private SFODetailsPage detailsPage = new SFODetailsPage();

    /**
     * iCanGoToOpportunitySection.
     */
    @Given("^I can go to opportunity section$")
    public void iCanGoToOpportunitySection() {
        tabClassic.setOpportunityTab();
    }

    /**
     * iCanCreateANewOpportunity.
     */
    @And("^I can create a new opportunity$")
    public void iCanCreateANewOpportunity() {
        mainPage.getNewAccountButton();
    }

    /**
     * @param values iCanCreateANewOpportunityFillTheFieldsAndPressTheSaveButton.
     */
    @And("^I can create a new opportunity fill the fields and press the save button$")
    public void iCanCreateANewOpportunityFillTheFieldsAndPressTheSaveButton(final Map<OpportInputs, String> values) {
        values.keySet().stream().forEach(step
                -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        modifyPage.getSaveNewAccountButton();
    }

    /**
     * @param opportunityName iCanVerifyTheNewOpportunity.
     */
    @Then("^I can verify the new opportunity \"([^\"]*)\"$")
    public void iCanVerifyTheNewOpportunity(final String opportunityName) {
        Assert.assertEquals(detailsPage.getNewAccountSavedName(), opportunityName);
    }

    /**
     * iChooseAnOpportunityAndPressTheEditButton.
     */
    @When("^I choose an opportunity and press the edit button$")
    public void iChooseAnOpportunityAndPressTheEditButton() {
        mainPage.getAccountNameLink();
        detailsPage.getEditButton();
    }

    /**
     * iChooseAnOpportunityAndPressTheDeleteButton.
     */
    @When("^I choose an opportunity and press the delete button$")
    public void iChooseAnOpportunityAndPressTheDeleteButton() {
        mainPage.getAccountNameLink();
        detailsPage.getDeleteButton();
        detailsPage.clickDeleteAlert();
    }

    /**
     * iCanVerifyThatTheOpportunityWasDeleted.
     */
    @Then("^I can verify that the opportunity was deleted$")
    public void iCanVerifyThatTheOpportunityWasDeleted() {
        Assert.assertEquals(mainPage.getAccountHomePage(), "home");

    }
}
