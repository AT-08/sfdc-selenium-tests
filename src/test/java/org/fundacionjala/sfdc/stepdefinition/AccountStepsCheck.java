package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import org.fundacionjala.sfdc.pageobjects.accounts.AccountInputs;
import org.fundacionjala.sfdc.pageobjects.accounts.SFANewModifyPage;

import java.util.Map;

/**
 * AccountStepsCheck.
 */
public class AccountStepsCheck {
    private SFANewModifyPage modifyPage;

    /**
     * AccountStepsCheck.
     *
     * @param modifyPage    modifyPage menu.
     */
    public AccountStepsCheck(final SFANewModifyPage modifyPage) {
        this.modifyPage = modifyPage;
    }

    /**
     * @param values iCanFillTheFieldsAndPressTheSaveButton.
     */
    @And("^I can fill the fields of Account and press the save button$")
    public void iCanFillTheFieldsAndPressTheSaveButton(final Map<AccountInputs, String> values) {
        values.keySet().forEach(step -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        modifyPage.getSaveNewAccountButton();
    }
}
