package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.pageobjects.SalesForceObject;
import org.fundacionjala.sfdc.pageobjects.SalesForceSection;
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

    private SalesForceSection tabClassic;
    private SFOMainPage mainPage;
    private SFONewModifyPage modifyPage;
    private SFODetailsPage detailsPage;

    /**
     * OpportunityStepsCheck.
     *
     * @param tabClassic  tabClassic menu.
     * @param mainPage    mainPage menu.
     * @param modifyPage  modifyPage menu.
     * @param detailsPage detailsPage menu.
     */
    public OpportunityStepsCheck(final SalesForceSection tabClassic,
                                 final SFOMainPage mainPage,
                                 final SFONewModifyPage modifyPage,
                                 final SFODetailsPage detailsPage) {
        this.tabClassic = tabClassic;
        this.mainPage = mainPage;
        this.modifyPage = modifyPage;
        this.detailsPage = detailsPage;
    }

    /**
     * iCanGoToOpportunitySection.
     */
    @Given("^2I can go to \"([^\"]*)\" Section")
    public void iCanGoToOpportunitySection(SalesForceObject section) {
        tabClassic.goToSalesForceTab(section);
    }

    /**
     * iCanCreateANewOpportunity.
     */
    @And("^2I can create a new opportunity$")
    public void iCanCreateANewOpportunity() {
        mainPage.clickToNewButton();
    }

    /**
     * @param values iCanCreateANewOpportunityFillTheFieldsAndPressTheSaveButton.
     */
    @And("^2I can create a new opportunity fill the fields and press the save button$")
    public void iCanCreateANewOpportunityFillTheFieldsAndPressTheSaveButton(final Map<OpportInputs, String> values) {
        values.keySet().stream().forEach(step
                -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        modifyPage.getSaveNewAccountButton();
    }

    /**
     * @param opportunityName iCanVerifyTheNewOpportunity.
     */
    @Then("^2I can verify the new opportunity \"([^\"]*)\"$")
    public void iCanVerifyTheNewOpportunity(final String opportunityName) {
        Assert.assertEquals(detailsPage.getOpportunityName(), opportunityName);
    }

    /**
     * iChooseAnOpportunityAndPressTheEditButton.
     */
    @When("^2I choose an opportunity and press the edit button$")
    public void iChooseAnOpportunityAndPressTheEditButton() {
        mainPage.clickAccountNameLink();
        detailsPage.clickEditButton();
    }

    /**
     * iChooseAnOpportunityAndPressTheDeleteButton.
     */
    @When("^2I choose an opportunity and press the delete button$")
    public void iChooseAnOpportunityAndPressTheDeleteButton() {
        mainPage.clickAccountNameLink();
        detailsPage.clickEditButton();
        detailsPage.clickDeleteAlert();
    }

    /**
     * iCanVerifyThatTheOpportunityWasDeleted.
     */
    @Then("^2I can verify that the opportunity was deleted$")
    public void iCanVerifyThatTheOpportunityWasDeleted() {
        Assert.assertEquals(mainPage.getAccountHomePage(), "home");

    }
}
