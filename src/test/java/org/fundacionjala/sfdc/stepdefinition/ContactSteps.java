package org.fundacionjala.sfdc.stepdefinition;

import java.util.Map;

import cucumber.api.java.en.And;

import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.contacts.ContactInputs;
import org.fundacionjala.sfdc.pages.contacts.SFCNewModifyPage;

/**
 * ContactSteps.
 */
public class ContactSteps {

    private SFCNewModifyPage modifyPage;
    private Helper helperToHook;

    /**
     * ContactSteps.
     *
     * @param modifyPage   modifyPage menu.
     * @param helperToHook helper.
     */
    public ContactSteps(final SFCNewModifyPage modifyPage, final Helper helperToHook) {
        this.modifyPage = modifyPage;
        this.helperToHook = helperToHook;
    }

    /**
     * @param values iCreateANewContactFillTheFieldsAndPressTheSaveButton.
     */
    @And("^I fill the fields of Contact and press the save button")
    public void iCreateANewContactFillTheFieldsAndPressTheSaveButton(final Map<ContactInputs, String> values) {
        helperToHook.setContactName(values.get(ContactInputs.CONTACT_LAST_NAME));
        values.keySet().forEach(step -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        modifyPage.getSaveNewAccountButton();
    }

}
