package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import org.fundacionjala.sfdc.pageobjects.accounts.AccountInputs;
import org.fundacionjala.sfdc.pageobjects.accounts.SFANewModifyPage;

import java.util.Map;

/**
 * AccountSteps.
 */
public class AccountSteps {
    private SFANewModifyPage modifyPage;

    /**
     * AccountSteps.
     *
     * @param modifyPage    modifyPage menu.
     */
    public AccountSteps(final SFANewModifyPage modifyPage) {
        this.modifyPage = modifyPage;
    }

    /**
     * @param values iFillTheFieldsAndPressTheSaveButton.
     */
    @And("^I fill the fields of Account and press the save button$")
    public void iFillTheFieldsAndPressTheSaveButton(final Map<AccountInputs, String> values) {
        values.keySet().forEach(step -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        modifyPage.getSaveNewAccountButton();
    }
}
