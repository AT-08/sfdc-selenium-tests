package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pageobjects.accounts.AccountInputs;
import org.fundacionjala.sfdc.pageobjects.accounts.SFANewModifyPage;

import java.util.Map;

/**
 * AccountSteps.
 */
public class AccountSteps {
    private SFANewModifyPage modifyPage;
    private Helper helperToHook;

    /**
     * AccountSteps.
     *
     * @param modifyPage modifyPage menu.
     * @param helperToHook helper.
     */
    public AccountSteps(final SFANewModifyPage modifyPage, final Helper helperToHook) {

        this.modifyPage = modifyPage;
        this.helperToHook = helperToHook;
    }

    /**
     * @param values iFillTheFieldsAndPressTheSaveButton.
     */
    @And("^I fill the fields of Account and press the save button$")
    public void iFillTheFieldsAndPressTheSaveButton(final Map<AccountInputs, String> values) {
        helperToHook.setAccountName(values.get(AccountInputs.ACCOUNT_NAME));
        values.keySet().forEach(step -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        modifyPage.getSaveNewAccountButton();
    }
}
