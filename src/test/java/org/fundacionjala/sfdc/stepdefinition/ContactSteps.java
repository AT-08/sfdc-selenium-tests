package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import org.fundacionjala.sfdc.pageobjects.contacts.ContactInputs;
import org.fundacionjala.sfdc.pageobjects.contacts.SFCNewModifyPage;

import java.util.Map;

/**
 * ContactSteps.
 */
public class ContactSteps {

    private SFCNewModifyPage modifyPage;

    /**
     * ContactSteps.
     *
     * @param modifyPage  modifyPage menu.
     */
    public ContactSteps(final SFCNewModifyPage modifyPage) {
        this.modifyPage = modifyPage;
    }
    /**
     * @param values iCreateANewContactFillTheFieldsAndPressTheSaveButton.
     */
    @And("^I fill the fields of Contact and press the save button")
    public void iCreateANewContactFillTheFieldsAndPressTheSaveButton(final Map<ContactInputs, String> values) {
        values.keySet().stream().forEach(step -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        modifyPage.getSaveNewAccountButton();
    }

}
