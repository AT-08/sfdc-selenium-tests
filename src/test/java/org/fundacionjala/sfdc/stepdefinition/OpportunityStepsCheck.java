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
    private SFONewModifyPage modifyPage;

    /**
     * OpportunityStepsCheck.
     *
     * @param modifyPage  modifyPage menu.
     */
    public OpportunityStepsCheck(final SFONewModifyPage modifyPage) {
        this.modifyPage = modifyPage;

    }

    /**
     * @param values iCanCreateANewOpportunityFillTheFieldsAndPressTheSaveButton.
     */
    @And("^I can create a new opportunity fill the fields and press the save button$")
    public void iCanCreateANewOpportunityFillTheFieldsAndPressTheSaveButton(final Map<OpportInputs, String> values) {
        values.keySet().forEach(step
                -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        modifyPage.getSaveNewAccountButton();
    }

}
