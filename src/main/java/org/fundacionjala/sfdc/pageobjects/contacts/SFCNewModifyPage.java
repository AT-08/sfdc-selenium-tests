package org.fundacionjala.sfdc.pageobjects.contacts;


import org.fundacionjala.sfdc.pageobjects.SalesForceConnection;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Inputs;
import org.fundacionjala.sfdc.util.Value;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.Map;

/**
 * SFCNewModifyPage.java
 * Class that represents the form where you fill fields in order to create or modify a contact.
 */
public class SFCNewModifyPage extends SalesForceConnection {
    @FindBy(how = How.ID, using = "name_firstcon2")
    private WebElement contactNameTextField;

    @FindBy(how = How.ID, using = "name_lastcon2")
    private WebElement contactLastNameTextField;

    @FindBy(how = How.ID, using = "con5")
    private WebElement contactTitleTextField;

    @FindBy(how = How.ID, using = "con6")
    private WebElement contactDepartmentTextField;

    @FindBy(how = How.ID, using = "con7")
    private WebElement contactBirthdateTextField;

    @FindBy(how = How.ID, using = "con9")
    private WebElement contactLeadSourceTextField;

    @FindBy(how = How.ID, using = "con10")
    private WebElement contactPhoneTextField;

    @FindBy(how = How.ID, using = "con13")
    private WebElement contactHomePhoneTextField;

    @FindBy(how = How.CSS, using = "#topButtonRow> input[name='save']")
    private WebElement saveContactButton;

    /**
     * Method to get "save" button.
     *
     * @return web element save button.
     */
    public WebElement getSaveContactButton() {
        return CommonActions.getElement(this.saveContactButton);
    }

    /**
     * Method to set contactName attribute.
     *
     * @param contactName string value.
     */
    public void setContactNameTextField(final String contactName) {
        this.contactNameTextField.clear();
        this.contactNameTextField.sendKeys(contactName);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactLastName string value.
     */
    public void setContactLastNameTextField(final String contactLastName) {
        this.contactLastNameTextField.clear();
        this.contactLastNameTextField.sendKeys(contactLastName);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactTitleTextField string value.
     */
    public void setContactTitleTextField(final String contactTitleTextField) {
        this.contactTitleTextField.clear();
        this.contactTitleTextField.sendKeys(contactTitleTextField);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactDepartmentTextField string value.
     */
    public void setContactDepartmentTextField(final String contactDepartmentTextField) {
        this.contactDepartmentTextField.clear();
        this.contactDepartmentTextField.sendKeys(contactDepartmentTextField);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactBirthdateTextField string value.
     */
    public void setContactBirthdateTextField(final String contactBirthdateTextField) {
        this.contactBirthdateTextField.clear();
        this.contactBirthdateTextField.sendKeys(contactBirthdateTextField);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactLeadSourceTextField string value.
     */
    public void setContactLeadSourceTextField(final String contactLeadSourceTextField) {
        this.contactLeadSourceTextField.sendKeys(contactLeadSourceTextField);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactPhoneTextField string value.
     */
    public void setContactPhoneTextField(final String contactPhoneTextField) {
        this.contactPhoneTextField.clear();
        this.contactPhoneTextField.sendKeys(contactPhoneTextField);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactHomePhoneTextField string value.
     */
    public void setContactHomePhoneTextField(final String contactHomePhoneTextField) {
        this.contactHomePhoneTextField.clear();
        this.contactHomePhoneTextField.sendKeys(contactHomePhoneTextField);
    }

    /**
     * Method to do click "save" button.
     */
    public void clickSaveContactButton() {
        getSaveContactButton().click();
    }


    /**
     * @param values contact field
     * @return map of contact fields.
     */
    public Map<Inputs, Value> getStrategyStepMap(final Map<Inputs, String> values) {
        Map<Inputs, Value> strategyMap = new HashMap<>();

        strategyMap.put(Inputs.CONTACT_NAME, () ->
                this.setContactNameTextField(String.valueOf(values.get(Inputs.CONTACT_NAME))));
        strategyMap.put(Inputs.CONTACT_LASTNAME, () ->
                this.setContactLastNameTextField(String.valueOf(values.get(Inputs.CONTACT_LASTNAME))));
        strategyMap.put(Inputs.CONTACT_TITLE, () ->
                this.setContactTitleTextField((String.valueOf(values.get(Inputs.CONTACT_TITLE)))));
        strategyMap.put(Inputs.CONTACT_DEPARTMENT, () ->
                this.setContactDepartmentTextField(String.valueOf(values.get(Inputs.CONTACT_DEPARTMENT))));
        strategyMap.put(Inputs.CONTACT_BIRTHDAY, () ->
                this.setContactBirthdateTextField(String.valueOf(values.get(Inputs.CONTACT_BIRTHDAY))));
        strategyMap.put(Inputs.CONTACT_LEADSOURCE, () ->
                this.setContactLeadSourceTextField(String.valueOf(values.get(Inputs.CONTACT_LEADSOURCE))));
        strategyMap.put(Inputs.CONTACT_PHONE, () ->
                this.setContactPhoneTextField(String.valueOf(values.get(Inputs.CONTACT_PHONE))));
        strategyMap.put(Inputs.CONTACT_HOMEPHONE, () ->
                this.setContactHomePhoneTextField(String.valueOf(values.get(Inputs.CONTACT_HOMEPHONE))));

        return strategyMap;

    }
}
