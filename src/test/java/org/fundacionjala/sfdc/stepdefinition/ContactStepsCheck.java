package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import org.fundacionjala.sfdc.pageobjects.contacts.ContactInputs;
import org.fundacionjala.sfdc.pageobjects.contacts.SFCNewModifyPage;
import org.fundacionjala.sfdc.pageobjects.opportunities.SFONewModifyPage;

import java.util.Map;

/**
 * ContactStepsCheck.
 */
public class ContactStepsCheck {

    private SFCNewModifyPage modifyPage;

    /**
     * ContactStepsCheck.
     *
     * @param modifyPage  modifyPage menu.
     */
    public ContactStepsCheck(final SFCNewModifyPage modifyPage) {
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
