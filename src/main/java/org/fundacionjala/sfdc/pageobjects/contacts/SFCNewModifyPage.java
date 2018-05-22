package org.fundacionjala.sfdc.pageobjects.contacts;


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
 * SFCNewModifyPage.java
 * Class that represents the form where you fill fields in order to create or modify a contact.
 */
public class SFCNewModifyPage extends SFNewModify {

    @FindAll({
            @FindBy(how = How.ID, using = "name_firstcon2"),
            @FindBy(how = How.CSS, using = "fieldset > div > div:nth-child(2) > input")
    })
    private WebElement contactNameTextField;
    @FindAll({
            @FindBy(how = How.ID, using = "name_lastcon2"),
            @FindBy(how = How.CSS, using = "fieldset > div > div:nth-child(3) > input")
    })
    private WebElement contactLastNameTextField;

    @FindAll({
            @FindBy(how = How.ID, using = "con5"),
            @FindBy(how = How.CSS, using = "div:nth-child(4) > div:nth-child(1) > div > div > div > input")
    })
    private WebElement contactTitleTextField;

    @FindAll({
            @FindBy(how = How.ID, using = "con6"),
            @FindBy(how = How.CSS, using = "div:nth-child(5) > div:nth-child(1) > div > div > div > input")
    })
    private WebElement contactDepartmentTextField;

    @FindAll({
            @FindBy(how = How.ID, using = "con7"),
            @FindBy(how = How.CSS, using = "div:nth-child(6) > div:nth-child(1) > div > div > div > div > input")
    })
    private WebElement contactBirthdateTextField;

    @FindAll({
            @FindBy(how = How.ID, using = "con9"),
    })
    private WebElement contactLeadSourceTextField;

    @FindAll({
            @FindBy(how = How.ID, using = "con10"),
    })
    private WebElement contactPhoneTextField;

    @FindAll({
            @FindBy(how = How.ID, using = "con13"),
            @FindBy(how = How.CSS, using = "div:nth-child(2) > div:nth-child(2) > div > div > div > input")
    })
    private WebElement contactHomePhoneTextField;

    /**
     * Method to set contactName attribute.
     *
     * @param contactName string value.
     */
    private void setContactNameTextField(final String contactName) {
        CommonActions.clearField(this.contactNameTextField);
        CommonActions.setTextElement(this.contactNameTextField, contactName);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactLastName string value.
     */
    private void setContactLastNameTextField(final String contactLastName) {

        CommonActions.clearField(this.contactLastNameTextField);
        CommonActions.setTextElement(this.contactLastNameTextField, contactLastName);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactTitleTextField string value.
     */
    private void setContactTitleTextField(final String contactTitleTextField) {
        CommonActions.clearField(this.contactTitleTextField);
        CommonActions.setTextElement(this.contactTitleTextField, contactTitleTextField);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactDepartmentTextField string value.
     */
    private void setContactDepartmentTextField(final String contactDepartmentTextField) {
        CommonActions.clearField(this.contactDepartmentTextField);
        CommonActions.setTextElement(this.contactDepartmentTextField, contactDepartmentTextField);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactBirthdateTextField string value.
     */
    private void setContactBirthdateTextField(final String contactBirthdateTextField) {
        CommonActions.clearField(this.contactBirthdateTextField);
        CommonActions.setTextElement(this.contactBirthdateTextField, contactBirthdateTextField);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactLeadSourceTextField string value.
     */
    private void setContactLeadSourceTextField(final String contactLeadSourceTextField) {
        CommonActions.setTextElement(this.contactLeadSourceTextField, contactLeadSourceTextField);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactPhoneTextField string value.
     */
    private void setContactPhoneTextField(final String contactPhoneTextField) {
        CommonActions.clearField(this.contactPhoneTextField);
        CommonActions.setTextElement(this.contactPhoneTextField, contactPhoneTextField);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactHomePhoneTextField string value.
     */
    private void setContactHomePhoneTextField(final String contactHomePhoneTextField) {
        CommonActions.clearField(this.contactHomePhoneTextField);
        CommonActions.setTextElement(this.contactHomePhoneTextField, contactHomePhoneTextField);
    }


    /**
     * @param values contact field
     * @return map of contact fields.
     */
    public Map<ContactInputs, Value> getStrategyStepMap(final Map<ContactInputs, String> values) {
        Map<ContactInputs, Value> strategyMap = new HashMap<>();

        strategyMap.put(ContactInputs.CONTACT_NAME, () ->
                this.setContactNameTextField(String.valueOf(values.get(ContactInputs.CONTACT_NAME))));
        strategyMap.put(ContactInputs.CONTACT_LASTNAME, () ->
                this.setContactLastNameTextField(String.valueOf(values.get(ContactInputs.CONTACT_LASTNAME))));
        strategyMap.put(ContactInputs.CONTACT_TITLE, () ->
                this.setContactTitleTextField(String.valueOf(values.get(ContactInputs.CONTACT_TITLE))));
        strategyMap.put(ContactInputs.CONTACT_DEPARTMENT, () ->
                this.setContactDepartmentTextField(String.valueOf(values.get(ContactInputs.CONTACT_DEPARTMENT))));
        strategyMap.put(ContactInputs.CONTACT_BIRTHDAY, () ->
                this.setContactBirthdateTextField(String.valueOf(values.get(ContactInputs.CONTACT_BIRTHDAY))));
        strategyMap.put(ContactInputs.CONTACT_LEADSOURCE, () ->
                this.setContactLeadSourceTextField(String.valueOf(values.get(ContactInputs.CONTACT_LEADSOURCE))));
        strategyMap.put(ContactInputs.CONTACT_PHONE, () ->
                this.setContactPhoneTextField(String.valueOf(values.get(ContactInputs.CONTACT_PHONE))));
        strategyMap.put(ContactInputs.CONTACT_HOMEPHONE, () ->
                this.setContactHomePhoneTextField(String.valueOf(values.get(ContactInputs.CONTACT_HOMEPHONE))));

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
