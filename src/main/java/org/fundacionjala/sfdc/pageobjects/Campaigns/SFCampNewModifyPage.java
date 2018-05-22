package org.fundacionjala.sfdc.pageobjects.Campaigns;

import org.fundacionjala.sfdc.pageobjects.SFNewModify;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Value;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.EnumMap;
import java.util.Map;

/**
 * SFCampNewModifyPage.
 */
public class SFCampNewModifyPage extends SFNewModify {

    @FindAll({
            @FindBy(how = How.ID, using = "cpn1"),
            @FindBy(how = How.ID, using = "58:2291;a")
    })
    private WebElement campaignName;

    @FindAll({
            @FindBy(how = How.ID, using = "cpn16"),
            @FindBy(how = How.ID, using = "92:2291;a")
    })
    private WebElement campaignActiveCheckbox;

    @FindAll({
            @FindBy(how = How.ID, using = "cpn2"),
            @FindBy(how = How.CSS, using = "#\\31 33\\:2291\\;a > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)")
    })
    private WebElement campaignType;

    @FindAll({
            @FindBy(how = How.ID, using = "cpn3"),
            @FindBy(how = How.CSS, using = "#\\31 97\\:2291\\;a > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)")
    })
    private WebElement campaignStatus;

    @FindAll({
            @FindBy(how = How.ID, using = "cpn5"),
            @FindBy(how = How.ID, using = "41:2731;a")
    })
    private WebElement campaignStartDate;

    @FindAll({
            @FindBy(how = How.ID, using = "cpn6"),
            @FindBy(how = How.ID, using = "79:2731;a")
    })
    private WebElement campaignEndDate;

    @FindAll({
            @FindBy(how = How.ID, using = "cpn8"),
            @FindBy(how = How.ID, using = "122:2731;a")
    })
    private WebElement campaignExpectedRevenue;

    @FindAll({
            @FindBy(how = How.ID, using = "cpn9"),
            @FindBy(how = How.CSS, using = "#\\32 59\\:2731\\;a > div:nth-child(1) > a:nth-child(1)")

    })
    private WebElement campaignBudgetedCost;

    @FindAll({
            @FindBy(how = How.ID, using = "cpn10"),
            @FindBy(how = How.ID, using = "349:2731;a")
    })
    private WebElement campaignActualCost;

    @FindAll({
            @FindBy(how = How.ID, using = "cpn11"),
            @FindBy(how = How.ID, using = "420:2731;a")
    })
    private WebElement campaignExpectedResponse;

    @FindAll({
            @FindBy(how = How.ID, using = "cpn13"),
            @FindBy(how = How.ID, using = "529:2731;a")
    })
    private WebElement campaignNumSent;

    @FindAll({
            @FindBy(how = How.ID, using = "Parent"),
            @FindBy(how = How.ID, using = "565:2731;a")
    })
    private WebElement parentCampaign;

    @FindAll({
            @FindBy(how = How.ID, using = "cpn4"),
            @FindBy(how = How.ID, using = "631:2731;a")
    })
    private WebElement campaignDescription;

    /**
     * setPrivateCheckbox.
     */
    private void setCampaignActiveCheckbox() {
        CommonActions.clickElement(this.campaignActiveCheckbox);
    }

    /**
     * @param opportunityName setOpportunityName.
     */
    private void setOpportunityName(final String opportunityName) {
        CommonActions.clearField(this.opportunityName);
        CommonActions.setTextElement(this.opportunityName, opportunityName);
    }

    /**
     * @param accountName setAccountName.
     */
    private void setAccountName(final String accountName) {
        CommonActions.clearField(this.accountName);
        CommonActions.setTextElement(this.accountName, accountName);
    }

    /**
     * @param closeDate setOpportunityCloseDate.
     */
    private void setOpportunityCloseDate(final String closeDate) {
        CommonActions.clearField(this.opportunityCloseDate);
        CommonActions.setTextElement(this.opportunityCloseDate, closeDate);
    }

    /**
     * @param stage setOpportunityStage.
     */
    private void setOpportunityStage(final String stage) {
        CommonActions.setTextElement(this.opportunityStage, stage);
    }


    /**
     * @param values contact field
     * @return map of contact fields.
     */
    public Map<CampaignInputs, Value> getStrategyStepMap(final Map<CampaignInputs, String> values) {
        EnumMap<CampaignInputs, Value> strategyMap = new EnumMap<>(CampaignInputs.class);

        strategyMap.put(CampaignInputs.OPPORTUNITY_NAME, () ->
                this.setOpportunityName(String.valueOf(values.get(CampaignInputs.OPPORTUNITY_NAME))));
        strategyMap.put(CampaignInputs.OPPORTUNITY_CLOSE_DATE, () ->
                this.setOpportunityCloseDate(String.valueOf(values.get(CampaignInputs.OPPORTUNITY_CLOSE_DATE))));
        strategyMap.put(CampaignInputs.OPPORTUNITY_STAGE, () ->
                this.setOpportunityStage(String.valueOf(values.get(CampaignInputs.OPPORTUNITY_STAGE))));

        return strategyMap;
    }

    /**
     * getSaveNewAccountButton.
     */
    @Override
    public void getSaveNewAccountButton() {
        CommonActions.clickElement(this.saveNewAccountButton);
    }

}
