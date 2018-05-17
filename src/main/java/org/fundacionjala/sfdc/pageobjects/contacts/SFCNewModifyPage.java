package org.fundacionjala.sfdc.pageobjects.contacts;


import org.fundacionjala.sfdc.pageobjects.BasePage;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Value;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;
/**
 * SFCNewModifyPage.java
 * Class that represents the form where you fill fields in order to create or modify a contact.
 */
public class SFCNewModifyPage extends BasePage {
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

    private Map<String, Value> newContactsFields = new HashMap<>();

    /**
     * Constructor.
     */
    public SFCNewModifyPage() {
        super();
        PageFactory.initElements(this.webDriver, this);
    }

    /**
     * Method to get "save" button.
     * @return web element save button.
     */
    public WebElement getSaveContactButton() {
        return CommonActions.getElement(this.saveContactButton);
    }

    /**
     * Method to set contactName attribute.
     * @param contactName string value.
     */
    public void setContactNameTextField(final String contactName) {
        this.contactNameTextField.clear();
        this.contactNameTextField.sendKeys(contactName);
    }

    /**
     * Method to set contact las Name attribute.
     * @param contactLastName string value.
     */
    public void setContactLastNameTextField(final String contactLastName) {
        this.contactLastNameTextField.clear();
        this.contactLastNameTextField.sendKeys(contactLastName);
    }

    /**
     * Method to set contact las Name attribute.
     * @param contactTitleTextField string value.
     */
    public void setContactTitleTextField(final String contactTitleTextField) {
        this.contactTitleTextField.clear();
        this.contactTitleTextField.sendKeys(contactTitleTextField);
    }

    /**
     * Method to set contact las Name attribute.
     * @param contactDepartmentTextField string value.
     */
    public void setContactDepartmentTextField(final String contactDepartmentTextField) {
        this.contactDepartmentTextField.clear();
        this.contactDepartmentTextField.sendKeys(contactDepartmentTextField);
    }

    /**
     * Method to set contact las Name attribute.
     * @param contactBirthdateTextField string value.
     */
    public void setContactBirthdateTextField(final String contactBirthdateTextField) {
        this.contactBirthdateTextField.clear();
        this.contactBirthdateTextField.sendKeys(contactBirthdateTextField);
    }

    /**
     * Method to set contact las Name attribute.
     * @param contactLeadSourceTextField string value.
     */
    public void setContactLeadSourceTextField(final String contactLeadSourceTextField) {
        this.contactLeadSourceTextField.sendKeys(contactLeadSourceTextField);
    }

    /**
     * Method to set contact las Name attribute.
     * @param contactPhoneTextField string value.
     */
    public void setContactPhoneTextField(final String contactPhoneTextField) {
        this.contactPhoneTextField.clear();
        this.contactPhoneTextField.sendKeys(contactPhoneTextField);
    }

    /**
     * Method to set contact las Name attribute.
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
     * Method to do click "fillMethodsToFields" to map.
     * @return map of contact fields.
     */
    public Map<String, Value> fillMethodsToFields() {
        newContactsFields.put("contactName", this::setContactNameTextField);
        newContactsFields.put("contactLastName", this::setContactLastNameTextField);
        newContactsFields.put("contactTitle", this::setContactTitleTextField);
        newContactsFields.put("contactDepartment", this::setContactDepartmentTextField);
        newContactsFields.put("contactBirthday", this::setContactBirthdateTextField);
        newContactsFields.put("contactLeadSource", this::setContactLeadSourceTextField);
        newContactsFields.put("contactPhone", this::setContactPhoneTextField);
        newContactsFields.put("contactHomePhone", this::setContactHomePhoneTextField);
        return newContactsFields;
    }
}
