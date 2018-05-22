package org.fundacionjala.sfdc.pageobjects.opportunities;

import org.fundacionjala.sfdc.pageobjects.SFNewModify;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Value;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.Map;

/**
 * SFONewModifyPage.
 */
public class SFONewModifyPage extends SFNewModify {

    @FindAll({
            @FindBy(how = How.CSS, using = "#opp3"),
    })
    private WebElement opportunityName;

    @FindAll({
            @FindBy(how = How.CSS, using = "#opp9"),
    })
    private WebElement opportunityCloseDate;

    @FindAll({
            @FindBy(how = How.CSS, using = "#opp11")
    })
    private WebElement opportunityStage;

    /**
     * @param opportunityName setOpportunityName.
     */
    private void setOpportunityName(final String opportunityName) {
        CommonActions.clearField(this.opportunityName);
        CommonActions.setTextElement(this.opportunityName, opportunityName);
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
        Map<OpportInputs, Value> strategyMap = new HashMap<>();

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
