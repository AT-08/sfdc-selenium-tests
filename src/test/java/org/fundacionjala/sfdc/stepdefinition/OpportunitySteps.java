package org.fundacionjala.sfdc.stepdefinition;

import java.util.Map;

import cucumber.api.java.en.And;

import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.opportunities.OpportInputs;
import org.fundacionjala.sfdc.pages.opportunities.SFONewModifyPage;

/**
 * OpportunitySteps.
 */
public class OpportunitySteps {
    private SFONewModifyPage modifyPage;
    private Helper helperToHook;

    /**
     * Constructor for Opportunity Steps.
     *
     * @param modifyPage   modifyPage menu.
     * @param helperToHook helper.
     */
    public OpportunitySteps(final SFONewModifyPage modifyPage, final Helper helperToHook) {
        this.modifyPage = modifyPage;
        this.helperToHook = helperToHook;
    }

    /**
     * Fill The Fields Of Opportunity.
     *
     * @param values Map of opportunities fields and values.
     */
    @And("^I fill the fields of Opportunity and press the save button$")
    public void iFillTheFieldsOfOpportunityAndPressTheSaveButton(final Map<OpportInputs,
            String> values) {
        helperToHook.setOpportunityName(values.get(OpportInputs.OPPORTUNITY_NAME));
        values.keySet().forEach(step
                -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        modifyPage.getSaveNewAccountButton();
    }
}
