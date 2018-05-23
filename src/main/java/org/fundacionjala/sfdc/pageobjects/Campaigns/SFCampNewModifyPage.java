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
     * @param campaignName setCampaignName.
     */
    private void setCampaignName(final String campaignName) {
        CommonActions.setTextElement(this.campaignName, campaignName);
    }


    /**
     * @param campaignType setCampaignType.
     */
    private void setCampaignType(final String campaignType) {
        CommonActions.selectOnComboBox(this.campaignType, campaignType);
    }

    /**
     * @param campaignStatus setCampaignStatus.
     */
    private void setCampaignStatus(final String campaignStatus) {
        CommonActions.selectOnComboBox(this.campaignStatus, campaignStatus);
    }

    /**
     * @param campaignStartDate setCampaignStartDate.
     */
    private void setCampaignStartDate(final String campaignStartDate) {
        CommonActions.setTextElement(this.campaignStartDate, campaignStartDate);
    }

    /**
     * @param campaignExpectedRevenue setCampaignExpectedRevenue.
     */
    private void setCampaignExpectedRevenue(final String campaignExpectedRevenue) {
        CommonActions.setTextElement(this.campaignExpectedRevenue, campaignExpectedRevenue);
    }

    /**
     * @param campaignEndDate setCampaignEndDate.
     */
    private void setCampaignEndDate(final String campaignEndDate) {
        CommonActions.setTextElement(this.campaignEndDate, campaignEndDate);
    }

    /**
     * @param campaignBudgetedCost setCampaignBudgetedCost.
     */
    private void setCampaignBudgetedCost(final String campaignBudgetedCost) {
        CommonActions.setTextElement(this.campaignBudgetedCost, campaignBudgetedCost);
    }

    /**
     * @param campaignActualCost setCampaignActualCost.
     */
    private void setCampaignActualCost(final String campaignActualCost) {
        CommonActions.setTextElement(this.campaignActualCost, campaignActualCost);
    }

    /**
     * @param campaignExpectedResponse setCampaignExpectedResponse.
     */
    private void setCampaignExpectedResponse(final String campaignExpectedResponse) {
        CommonActions.setTextElement(this.campaignExpectedResponse, campaignExpectedResponse);
    }

    /**
     * @param campaignNumSent setCampaignNumSent.
     */
    private void setCampaignNumSent(final String campaignNumSent) {
        CommonActions.setTextElement(this.campaignNumSent, campaignNumSent);
    }

    /**
     * @param parentCampaign setParentCampaign.
     */
    private void setParentCampaign(final String parentCampaign) {
        CommonActions.setTextElement(this.parentCampaign, parentCampaign);
    }

    /**
     * @param campaignDescription setCampaignDescription.
     */
    private void setCampaignDescription(final String campaignDescription) {
        CommonActions.setTextElement(this.campaignDescription, campaignDescription);
    }

    /**
     * @param values contact field
     * @return map of contact fields.
     */
    public Map<CampaignInputs, Value> getStrategyStepMap(final Map<CampaignInputs, String> values) {
        EnumMap<CampaignInputs, Value> strategyMap = new EnumMap<>(CampaignInputs.class);

        strategyMap.put(CampaignInputs.CAMPAIGN_NAME, () ->
                this.setCampaignName(String.valueOf(values.get(CampaignInputs.CAMPAIGN_NAME))));
        strategyMap.put(CampaignInputs.CAMPAIGN_ACTIVE, () ->
                this.setCampaignActiveCheckbox());
        strategyMap.put(CampaignInputs.CAMPAIGN_TYPE, () ->
                this.setCampaignType(String.valueOf(values.get(CampaignInputs.CAMPAIGN_TYPE))));
        strategyMap.put(CampaignInputs.CAMPAIGN_STATUS, () ->
                this.setCampaignStatus(String.valueOf(values.get(CampaignInputs.CAMPAIGN_STATUS))));
        strategyMap.put(CampaignInputs.CAMPAIGN_START_DATE, () ->
                this.setCampaignStartDate(String.valueOf(values.get(CampaignInputs.CAMPAIGN_START_DATE))));
        strategyMap.put(CampaignInputs.CAMPAIGN_END_DATE, () ->
                this.setCampaignEndDate(String.valueOf(values.get(CampaignInputs.CAMPAIGN_END_DATE))));
        strategyMap.put(CampaignInputs.CAMPAIGN_EXPECTED_REVENUE, () ->
                this.setCampaignExpectedRevenue(String.valueOf(values.get(CampaignInputs.CAMPAIGN_EXPECTED_REVENUE))));
        strategyMap.put(CampaignInputs.CAMPAIGN_BUDGETED_COST, () ->
                this.setCampaignBudgetedCost(String.valueOf(values.get(CampaignInputs.CAMPAIGN_BUDGETED_COST))));
        strategyMap.put(CampaignInputs.CAMPAIGN_ACTUAL_COST, () ->
                this.setCampaignActualCost(String.valueOf(values.get(CampaignInputs.CAMPAIGN_ACTUAL_COST))));
        strategyMap.put(CampaignInputs.CAMPAIGN_EXPECTED_RESPONSE, () ->
                this.setCampaignExpectedResponse(String.valueOf(values
                        .get(CampaignInputs.CAMPAIGN_EXPECTED_RESPONSE))));
        strategyMap.put(CampaignInputs.CAMPAIGN_NUM_SENT, () ->
                this.setCampaignNumSent(String.valueOf(values.get(CampaignInputs.CAMPAIGN_NUM_SENT))));
        strategyMap.put(CampaignInputs.CAMPAIGN_PARENT, () ->
                this.setParentCampaign(String.valueOf(values.get(CampaignInputs.CAMPAIGN_PARENT))));
        strategyMap.put(CampaignInputs.CAMPAIGN_DESCRIPTION, () ->
                this.setCampaignDescription(String.valueOf(values.get(CampaignInputs.CAMPAIGN_DESCRIPTION))));
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
