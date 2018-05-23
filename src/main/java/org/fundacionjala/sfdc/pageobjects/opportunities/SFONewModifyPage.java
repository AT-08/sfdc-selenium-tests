package org.fundacionjala.sfdc.pageobjects.Opportunities;

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
public class SFONewModifyPage extends SFNewModify {

    //Opportunity Information.
    @FindAll({
            @FindBy(how = How.ID, using = "opp2"),
            @FindBy(how = How.ID, using = "63:2731;a")

    })
    private WebElement privateCheckbox;

    @FindAll({
            @FindBy(how = How.ID, using = "opp3"),
            @FindBy(how = How.ID, using = "106:2731;a")
    })
    private WebElement opportunityName;

    @FindAll({
            @FindBy(how = How.ID, using = "opp4"),
            @FindBy(how = How.ID, using = "142:2731;a")
    })
    private WebElement accountName;

    @FindAll({
            @FindBy(how = How.ID, using = "opp5"),
            @FindBy(how = How.CSS, using = "#\\33 12\\:2731\\;a > div:nth-child(1) > a:nth-child(1)")
    })
    private WebElement opportunityType;

    @FindAll({
            @FindBy(how = How.ID, using = "opp6"),
            @FindBy(how = How.CSS, using = "#\\33 90\\:2731\\;a > div:nth-child(1) > a:nth-child(1)")
    })
    private WebElement opportunityLeadSource;

    @FindAll({
            @FindBy(how = How.ID, using = "opp7"),
            @FindBy(how = How.ID, using = "41:2731;a")
    })
    private WebElement opportunityAmount;

    @FindAll({
            @FindBy(how = How.ID, using = "opp9"),
            @FindBy(how = How.ID, using = "79:2731;a")
    })
    private WebElement opportunityCloseDate;

    @FindAll({
            @FindBy(how = How.ID, using = "opp10"),
            @FindBy(how = How.ID, using = "122:2731;a")
    })
    private WebElement opportunityNextStep;

    @FindAll({
            @FindBy(how = How.ID, using = "opp11"),
            @FindBy(how = How.CSS, using = "#\\32 59\\:2731\\;a > div:nth-child(1) > a:nth-child(1)")

    })
    private WebElement opportunityStage;

    @FindAll({
            @FindBy(how = How.ID, using = "opp12"),
            @FindBy(how = How.ID, using = "349:2731;a")
    })
    private WebElement opportunityProbability;

    @FindAll({
            @FindBy(how = How.ID, using = "opp17"),
            @FindBy(how = How.ID, using = "420:2731;a")
    })
    private WebElement primaryCampaignSource;

    @FindAll({
            @FindBy(how = How.ID, using = "00Nf400000HnB9t"),
            @FindBy(how = How.ID, using = "529:2731;a")
    })

    //Additional Information.
    private WebElement orderNumber;

    @FindAll({
            @FindBy(how = How.ID, using = "00Nf400000HnB9q"),
            @FindBy(how = How.ID, using = "565:2731;a")
    })
    private WebElement currentGenerator;

    @FindAll({
            @FindBy(how = How.ID, using = "00Nf400000HnB9u"),
            @FindBy(how = How.ID, using = "631:2731;a")
    })
    private WebElement trackingNumber;

    @FindAll({
            @FindBy(how = How.ID, using = "00Nf400000HnB9s"),
            @FindBy(how = How.ID, using = "545:2731;a")
    })
    private WebElement mainCompetitors;

    @FindAll({
            @FindBy(how = How.ID, using = "00Nf400000HnB9r"),
            @FindBy(how = How.ID, using = "#\\35 97\\:2731\\;a > div:nth-child(1) > a:nth-child(1)")
    })
    private WebElement deliveryInstallationStatus;


    //Description Information.
    @FindAll({
            @FindBy(how = How.ID, using = "opp14"),
            @FindBy(how = How.ID, using = "676:2731;a")
    })
    private WebElement description;

    /**
     * setPrivateCheckbox.
     */
    private void setPrivateCheckbox() {
        CommonActions.clickElement(this.privateCheckbox);
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
        CommonActions.setTextElement(this.opportunityStage, stage);
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
                this.setPrivateCheckbox());
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
