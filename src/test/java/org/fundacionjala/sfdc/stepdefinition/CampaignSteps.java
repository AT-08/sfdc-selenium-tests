package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import org.fundacionjala.sfdc.pageobjects.campaigns.CampaignInputs;
import org.fundacionjala.sfdc.pageobjects.campaigns.SFCampNewModifyPage;

import java.util.Map;

/**
 * OpportunitySteps.
 */
public class CampaignSteps {
    private SFCampNewModifyPage modifyPage;

    /**
     * OpportunitySteps.
     *
     * @param modifyPage modifyPage menu.
     */
    public CampaignSteps(final SFCampNewModifyPage modifyPage) {
        this.modifyPage = modifyPage;

    }

    /**
     * @param values iCreateANewOpportunityFillTheFieldsAndPressTheSaveButton.
     */
    @And("^I create or modify a campaign fill the fields and press the save button$")
    public void iCreateOrModifyACampaignFillTheFieldsAndPressTheSaveButton(final Map<CampaignInputs,
            String> values) {
        values.keySet().forEach(step
                -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        modifyPage.getSaveNewAccountButton();
    }

}
