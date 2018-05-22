package org.fundacionjala.sfdc.pageobjects.opportunities;

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
    public Map<OpportInputs, Value> getStrategyStepMap(final Map<OpportInputs, String> values) {
        EnumMap<OpportInputs, Value> strategyMap = new EnumMap<>(OpportInputs.class);

        strategyMap.put(OpportInputs.OPPORTUNITY_NAME, () ->
                this.setOpportunityName(String.valueOf(values.get(OpportInputs.OPPORTUNITY_NAME))));
        strategyMap.put(OpportInputs.OPPORTUNITY_CLOSE_DATE, () ->
                this.setOpportunityCloseDate(String.valueOf(values.get(OpportInputs.OPPORTUNITY_CLOSE_DATE))));
        strategyMap.put(OpportInputs.OPPORTUNITY_STAGE, () ->
                this.setOpportunityStage(String.valueOf(values.get(OpportInputs.OPPORTUNITY_STAGE))));

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
