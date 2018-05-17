package org.fundacionjala.sfdc.pageobjects.opportunities;

import org.fundacionjala.sfdc.pageobjects.SFNewModify;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Inputs;
import org.fundacionjala.sfdc.util.Value;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.Map;

/**
 * SFONewModifyPage.
 */
public class SFONewModifyPage extends SFNewModify {


    @FindBy(how = How.CSS, using = "#opp3")
    private WebElement opportunityName;

    @FindBy(how = How.CSS, using = "#opp9")
    private WebElement opportunityCloseDate;

    @FindBy(how = How.CSS, using = "#opp11")
    private WebElement opportunityStage;


    /**
     * @param opportunityName setOpportunityName.
     */
    public void setOpportunityName(final String opportunityName) {
        this.opportunityName.clear();
        this.opportunityName.sendKeys(opportunityName);

    }

    /**
     * @param closeDate setOpportunityCloseDate.
     */
    public void setOpportunityCloseDate(final String closeDate) {
        this.opportunityCloseDate.clear();
        CommonActions.getElement(opportunityCloseDate);
        this.opportunityCloseDate.sendKeys(closeDate);
    }

    /**
     * @param stage setOpportunityStage.
     */
    public void setOpportunityStage(final String stage) {
        CommonActions.clickElement(opportunityCloseDate);
        this.opportunityCloseDate.sendKeys(stage);
        CommonActions.clickElement(opportunityCloseDate);
    }


    /**
     * @param values contact field
     * @return map of contact fields.
     */
    public Map<Inputs, Value> getStrategyStepMap(final Map<Inputs, String> values) {
        Map<Inputs, Value> strategyMap = new HashMap<>();

        strategyMap.put(Inputs.OPPORTUNITY_NAME, () ->
                this.setOpportunityName(String.valueOf(values.get(Inputs.OPPORTUNITY_NAME))));
        strategyMap.put(Inputs.OPPORTUNITY_CLOSE_DATE, () ->
                this.setOpportunityCloseDate(String.valueOf(values.get(Inputs.OPPORTUNITY_CLOSE_DATE))));
        strategyMap.put(Inputs.OPPORTUNITY_STAGE, () ->
                this.setOpportunityStage(String.valueOf(values.get(Inputs.OPPORTUNITY_STAGE))));

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
