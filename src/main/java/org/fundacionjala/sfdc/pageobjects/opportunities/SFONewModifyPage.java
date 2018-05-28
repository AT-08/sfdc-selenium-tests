package org.fundacionjala.sfdc.pageobjects.opportunities;

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
public class SFONewModifyPage extends SFNewModify {

    //Opportunity Information.
    @FindAll({
            @FindBy(id = "opp2"),
            @FindBy(xpath = "//span[text()='Private']/parent::label/following-sibling::input")

    })
    private WebElement privateCheckbox;

    @FindAll({
            @FindBy(id = "opp3"),
            @FindBy(xpath = "//span[text()='Opportunity Name']/parent::label/following-sibling::input")
    })
    private WebElement opportunityName;

    @FindAll({
            @FindBy(id = "opp4"),
            @FindBy(xpath = "//span[text()='Account Name']/parent::label/following-sibling::div/descendant::input")
    })
    private WebElement accountName;

    @FindAll({
            @FindBy(id = "opp5"),
            @FindBy(xpath = "//span[text()='Type']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement opportunityType;

    @FindAll({
            @FindBy(id = "opp6"),
            @FindBy(xpath = "//span[text()='Lead Source']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement opportunityLeadSource;

    @FindAll({
            @FindBy(id = "opp7"),
            @FindBy(xpath = "//span[text()='Amount']/parent::label/following-sibling::input")
    })
    private WebElement opportunityAmount;

    @FindAll({
            @FindBy(id = "opp9"),
            @FindBy(xpath = "//span[text()='Close Date']/parent::label/following-sibling::div/descendant::input")
    })
    private WebElement opportunityCloseDate;

    @FindAll({
            @FindBy(id = "opp10"),
            @FindBy(xpath = "//span[text()='Next Step']/parent::label/following-sibling::input")
    })
    private WebElement opportunityNextStep;

    @FindAll({
            @FindBy(id = "opp11"),
            @FindBy(xpath = "//span[text()='Stage']/parent::label/following-sibling::div/descendant::a")

    })
    private WebElement opportunityStage;

    @FindAll({
            @FindBy(id = "opp12"),
            @FindBy(xpath = "//span[text()='Probability (%)']/parent::label/following-sibling::input")
    })
    private WebElement opportunityProbability;

    @FindAll({
            @FindBy(id = "opp17"),
            @FindBy(xpath
                    = "//span[text()='Primary Campaign Source']/parent::label/following-sibling::div/descendant::input")
    })
    private WebElement primaryCampaignSource;

    //Additional Information.
    @FindAll({
            @FindBy(xpath = "//label[text()='Order Number']/parent::td/following-sibling::td[1]/input"),
            @FindBy(xpath = "//span[text()='Order Number']/parent::label/following-sibling::input")
    })
    private WebElement orderNumber;

    @FindAll({
            @FindBy(xpath = "//label[text()='Current Generator(s)']/parent::td/following-sibling::td[1]/input"),
            @FindBy(xpath = "//span[text()='Current Generator(s)']/parent::label/following-sibling::input")
    })
    private WebElement currentGenerator;

    @FindAll({
            @FindBy(xpath = "//label[text()='Tracking Number']/parent::td/following-sibling::td[1]/input"),
            @FindBy(xpath = "//span[text()='Tracking Number']/parent::label/following-sibling::input")
    })
    private WebElement trackingNumber;

    @FindAll({
            @FindBy(xpath = "//label[text()='Main Competitor(s)']/parent::td/following-sibling::td[1]/input"),
            @FindBy(xpath = "//span[text()='Main Competitor(s)']/parent::label/following-sibling::input")
    })
    private WebElement mainCompetitors;

    @FindAll({
            @FindBy(xpath = "//label[text()='Delivery/Installation Status']"
                    + "/parent::td/following-sibling::td[1]/descendant::select"),
            @FindBy(xpath = "//span[text()='Description']/parent::label/following-sibling::div/descendant::a")
    })
    private WebElement deliveryInstallationStatus;


    //Description Information.
    @FindAll({
            @FindBy(id = "opp14"),
            @FindBy(xpath = "//span[text()='Description']/parent::label/following-sibling::textarea")
    })
    private WebElement description;

    /**
     * setPrivateCheckbox.
     */
    private void setPrivateCheckbox(final String value) {
        CommonActions.setCheckBox(this.privateCheckbox, value);
    }

    /**
     * @param opportunityName setOpportunityName.
     */
    private void setOpportunityName(final String opportunityName) {
        CommonActions.setTextElement(this.opportunityName, opportunityName);
    }

    /**
     * @param accountName setAccountName.
     */
    private void setAccountName(final String accountName) {
        CommonActions.setTextElement(this.accountName, accountName);
    }

    /**
     * @param opportunityType setOpportunityType.
     */
    private void setOpportunityType(final String opportunityType) {
        CommonActions.selectOnComboBox(this.opportunityType, opportunityType);
    }

    /**
     * @param opportunityLeadSource setOpportunityLeadSource.
     */
    private void setOpportunityLeadSource(final String opportunityLeadSource) {
        CommonActions.selectOnComboBox(this.opportunityLeadSource, opportunityLeadSource);
    }

    /**
     * @param opportunityAmount setOpportunityAmount.
     */
    private void setOpportunityAmount(final String opportunityAmount) {
        CommonActions.setTextElement(this.opportunityAmount, opportunityAmount);
    }

    /**
     * @param closeDate setOpportunityCloseDate.
     */
    private void setOpportunityCloseDate(final String closeDate) {
        CommonActions.setTextElement(this.opportunityCloseDate, closeDate);
    }

    /**
     * @param opportunityNextStep setOpportunityNextStep.
     */
    private void setOpportunityNextStep(final String opportunityNextStep) {
        CommonActions.setTextElement(this.opportunityNextStep, opportunityNextStep);
    }

    /**
     * @param stage setOpportunityStage.
     */
    private void setOpportunityStage(final String stage) {
        CommonActions.selectOnComboBox(this.opportunityStage, stage);
    }

    /**
     * @param opportunityProbability setOpportunityProbability.
     */
    private void setOpportunityProbability(final String opportunityProbability) {
        CommonActions.setTextElement(this.opportunityProbability, opportunityProbability);
    }

    /**
     * @param primaryCampaignSource setPrimaryCampaignSource.
     */
    private void setPrimaryCampaignSource(final String primaryCampaignSource) {
        CommonActions.setTextElement(this.primaryCampaignSource, primaryCampaignSource);
    }

    /**
     * @param orderNumber setOrderNumber.
     */
    private void setOrderNumber(final String orderNumber) {
        CommonActions.setTextElement(this.orderNumber, orderNumber);
    }

    /**
     * @param currentGenerator setCurrentGenerator.
     */
    private void setCurrentGenerator(final String currentGenerator) {
        CommonActions.setTextElement(this.currentGenerator, currentGenerator);
    }

    /**
     * @param trackingNumber setTrackingNumber.
     */
    private void setTrackingNumber(final String trackingNumber) {
        CommonActions.setTextElement(this.trackingNumber, trackingNumber);
    }

    /**
     * @param mainCompetitors setMainCompetitors.
     */
    private void setMainCompetitors(final String mainCompetitors) {
        CommonActions.setTextElement(this.mainCompetitors, mainCompetitors);
    }

    /**
     * @param deliveryInstallationStatus setDeliveryInstallationStatus.
     */
    private void setDeliveryInstallationStatus(final String deliveryInstallationStatus) {
        CommonActions.selectOnComboBox(this.deliveryInstallationStatus, deliveryInstallationStatus);
    }

    /**
     * @param description setDescription.
     */
    private void setDescription(final String description) {
        CommonActions.setTextElement(this.description, description);
    }

    /**
     * @param values opportunity field
     * @return map of opportunity fields.
     */
    public Map<OpportInputs, Value> getStrategyStepMap(final Map<OpportInputs, String> values) {
        EnumMap<OpportInputs, Value> strategyMap = new EnumMap<>(OpportInputs.class);

        strategyMap.put(OpportInputs.OPPORTUNITY_PRIVATE, () ->
                this.setPrivateCheckbox(String.valueOf(values.get(OpportInputs.OPPORTUNITY_PRIVATE))));
        strategyMap.put(OpportInputs.OPPORTUNITY_NAME, () ->
                this.setOpportunityName(String.valueOf(values.get(OpportInputs.OPPORTUNITY_NAME))));
        strategyMap.put(OpportInputs.OPPORTUNITY_ACCOUNT_NAME, () ->
                this.setAccountName(String.valueOf(values.get(OpportInputs.OPPORTUNITY_ACCOUNT_NAME))));
        strategyMap.put(OpportInputs.OPPORTUNITY_TYPE, () ->
                this.setOpportunityType(String.valueOf(values.get(OpportInputs.OPPORTUNITY_TYPE))));
        strategyMap.put(OpportInputs.OPPORTUNITY_LEAD_SOURCE, () ->
                this.setOpportunityLeadSource(String.valueOf(values.get(OpportInputs.OPPORTUNITY_LEAD_SOURCE))));
        strategyMap.put(OpportInputs.OPPORTUNITY_AMOUNT, () ->
                this.setOpportunityAmount(String.valueOf(values.get(OpportInputs.OPPORTUNITY_AMOUNT))));
        strategyMap.put(OpportInputs.OPPORTUNITY_CLOSE_DATE, () ->
                this.setOpportunityCloseDate(String.valueOf(values.get(OpportInputs.OPPORTUNITY_CLOSE_DATE))));
        strategyMap.put(OpportInputs.OPPORTUNITY_NEXT_STEP, () ->
                this.setOpportunityNextStep(String.valueOf(values.get(OpportInputs.OPPORTUNITY_NEXT_STEP))));
        strategyMap.put(OpportInputs.OPPORTUNITY_STAGE, () ->
                this.setOpportunityStage(String.valueOf(values.get(OpportInputs.OPPORTUNITY_STAGE))));
        strategyMap.put(OpportInputs.OPPORTUNITY_PROBABILITY, () ->
                this.setOpportunityProbability(String.valueOf(values.get(OpportInputs.OPPORTUNITY_PROBABILITY))));
        strategyMap.put(OpportInputs.OPPORTUNITY_PRIMARY_CAMPAIGN_SOURCE, () ->
                this.setPrimaryCampaignSource(String.valueOf(values
                        .get(OpportInputs.OPPORTUNITY_PRIMARY_CAMPAIGN_SOURCE))));
        strategyMap.put(OpportInputs.OPPORTUNITY_ORDER_NUMBER, () ->
                this.setOrderNumber(String.valueOf(values.get(OpportInputs.OPPORTUNITY_ORDER_NUMBER))));
        strategyMap.put(OpportInputs.OPPORTUNITY_CURRENT_GENERATOR, () ->
                this.setCurrentGenerator(String.valueOf(values.get(OpportInputs.OPPORTUNITY_CURRENT_GENERATOR))));
        strategyMap.put(OpportInputs.OPPORTUNITY_TRACKING, () ->
                this.setTrackingNumber(String.valueOf(values.get(OpportInputs.OPPORTUNITY_TRACKING))));
        strategyMap.put(OpportInputs.OPPORTUNITY_MAIN_COMPETITORS, () ->
                this.setMainCompetitors(String.valueOf(values.get(OpportInputs.OPPORTUNITY_MAIN_COMPETITORS))));
        strategyMap.put(OpportInputs.OPPORTUNITY_DELIVERY_INSTALLATION_STATUS, () ->
                this.setDeliveryInstallationStatus(String.valueOf(values
                        .get(OpportInputs.OPPORTUNITY_DELIVERY_INSTALLATION_STATUS))));
        strategyMap.put(OpportInputs.OPPORTUNITY_DESCRIPTION, () ->
                this.setDescription(String.valueOf(values.get(OpportInputs.OPPORTUNITY_DESCRIPTION))));

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
