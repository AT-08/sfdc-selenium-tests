package org.fundacionjala.sfdc.pageobjects.campaigns;

import org.fundacionjala.sfdc.pageobjects.SFNewModify;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Value;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.EnumMap;
import java.util.Map;

/**
 * SFCampNewModifyPage.
 */
public class SFCampNewModifyPage extends SFNewModify {

    @FindAll({
            @FindBy(id = "cpn1"),
            @FindBy(xpath = "//span[text()='Campaign Name']/parent::label/following-sibling::input")
    })
    private WebElement campaignName;

    @FindAll({
            @FindBy(id = "cpn16"),
            @FindBy(xpath = "//span[text()='Active']/parent::label/following-sibling::input")
    })
    private WebElement campaignActiveCheckbox;

    @FindAll({
            @FindBy(id = "cpn2"),
            @FindBy(xpath = "//span[text()='Type']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement campaignType;

    @FindAll({
            @FindBy(id = "cpn3"),
            @FindBy(xpath = "//span[text()='Status']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement campaignStatus;

    @FindAll({
            @FindBy(id = "cpn5"),
            @FindBy(xpath = "//span[text()='Start Date']/parent::label/following-sibling::div/descendant::input")
    })
    private WebElement campaignStartDate;

    @FindAll({
            @FindBy(id = "cpn6"),
            @FindBy(xpath = "//span[text()='End Date']/parent::label/following-sibling::div/descendant::input")
    })
    private WebElement campaignEndDate;

    @FindAll({
            @FindBy(id = "cpn8"),
            @FindBy(xpath = "//span[text()='Expected Revenue in Campaign']/parent::label/following-sibling::input")
    })
    private WebElement campaignExpectedRevenue;

    @FindAll({
            @FindBy(id = "cpn9"),
            @FindBy(xpath = "//span[text()='Budgeted Cost in Campaign']/parent::label/following-sibling::input")

    })
    private WebElement campaignBudgetedCost;

    @FindAll({
            @FindBy(id = "cpn10"),
            @FindBy(xpath = "//span[text()='Actual Cost in Campaign']/parent::label/following-sibling::input")
    })
    private WebElement campaignActualCost;

    @FindAll({
            @FindBy(id = "cpn11"),
            @FindBy(xpath = "//span[text()='Expected Response (%)']/parent::label/following-sibling::input")
    })
    private WebElement campaignExpectedResponse;

    @FindAll({
            @FindBy(id = "cpn13"),
            @FindBy(xpath = "//span[text()='Num Sent in Campaign']/parent::label/following-sibling::input")
    })
    private WebElement campaignNumSent;

    @FindAll({
            @FindBy(id = "Parent"),
            @FindBy(xpath = "//span[text()='Parent Campaign']/parent::label/following-sibling::div/descendant::input")
    })
    private WebElement parentCampaign;

    @FindAll({
            @FindBy(id = "cpn4"),
            @FindBy(xpath = "//span[text()='Description']/parent::label/following-sibling::textarea")
    })
    private WebElement campaignDescription;

    /**
     * setPrivateCheckbox.
     *
     * @param value  a string representation of a boolean value.
     */
    private void setCampaignActiveCheckbox(final String value) {
        CommonActions.setCheckBox(this.campaignActiveCheckbox, value);
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
     * Method to set parentAccount attribute.
     *
     * @param parentCampaign the value.
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
                this.setCampaignActiveCheckbox(String.valueOf(values.get(CampaignInputs.CAMPAIGN_ACTIVE))));
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
