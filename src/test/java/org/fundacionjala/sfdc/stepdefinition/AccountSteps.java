package org.fundacionjala.sfdc.stepdefinition;

import java.util.Map;

import cucumber.api.java.en.And;

import org.fundacionjala.sfdc.api.APICommons;
import org.fundacionjala.sfdc.api.APIRequestManager;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.accounts.AccountInputs;
import org.fundacionjala.sfdc.pages.accounts.SFANewModifyPage;

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

    /**
     * Method to save response.
     *
     * @param variableName the key to save.
     */
    @And("^save the response as \"([^\"]*)\"$")
    public void saveTheResponseAs(final String variableName) {
        APICommons.saveResponse(variableName, APIRequestManager.getResponse());
    }
}
