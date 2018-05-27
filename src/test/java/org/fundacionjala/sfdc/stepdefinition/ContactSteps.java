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
     * @param values iCanCreateANewContactFillTheFieldsAndPressTheSaveButton.
     */
    @And("^I can fill the fields of Contact and press the save button")
    public void iCanCreateANewContactFillTheFieldsAndPressTheSaveButton(final Map<ContactInputs, String> values) {
        values.keySet().stream().forEach(step -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        modifyPage.getSaveNewAccountButton();
    }
}
