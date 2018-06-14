package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pageobjects.campaigns.CampaignInputs;
import org.fundacionjala.sfdc.pageobjects.campaigns.SFCampNewModifyPage;

import java.util.Map;

/**
 * OpportunitySteps.
 */
public class CampaignSteps {
    private SFCampNewModifyPage modifyPage;
    private Helper helperToHook;

    /**
     * OpportunitySteps.
     *
     * @param modifyPage   modifyPage menu.
     * @param helperToHook helper.
     */
    public CampaignSteps(final SFCampNewModifyPage modifyPage, final Helper helperToHook) {
        this.modifyPage = modifyPage;
        this.helperToHook = helperToHook;
    }

    /**
     * @param values iCreateANewOpportunityFillTheFieldsAndPressTheSaveButton.
     */
    @And("^I create or modify a campaign fill the fields and press the save button$")
    public void iCreateOrModifyACampaignFillTheFieldsAndPressTheSaveButton(final Map<CampaignInputs,
            String> values) {
        helperToHook.setCampaignName(values.get(CampaignInputs.CAMPAIGN_NAME));
        values.keySet().forEach(step
                -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        modifyPage.getSaveNewAccountButton();

    }

}
