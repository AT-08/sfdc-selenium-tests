package org.fundacionjala.sfdc.pageobjects.contacts;


import org.fundacionjala.core.selenium.CommonWebActions;
import org.fundacionjala.sfdc.pageobjects.common.SFNewModify;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Value;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.EnumMap;
import java.util.Map;

/**
 * SFCNewModifyPage.java
 * Class that represents the form where you fill fields in order to create or modify a contact.
 */
public class SFCNewModifyPage extends SFNewModify {
    @FindAll({
            @FindBy(id = "name_salutationcon2"),
            @FindBy(xpath = "//span[text()='Salutation']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement contactSalutation;
    @FindAll({
            @FindBy(id = "name_firstcon2"),
            @FindBy(xpath = "//span[text()='First Name']/parent::label/following-sibling::input")
    })
    private WebElement contactNameTextField;
    @FindAll({
            @FindBy(id = "name_lastcon2"),
            @FindBy(xpath = "//span[text()='Last Name']/parent::label/following-sibling::input")
    })
    private WebElement contactLastNameTextField;

    @FindAll({
            @FindBy(id = "con5"),
            @FindBy(xpath = "//span[text()='Title']/parent::label/following-sibling::input")
    })
    private WebElement contactTitleTextField;

    @FindAll({
            @FindBy(id = "con6"),
            @FindBy(xpath = "//span[text()='Department']/parent::label/following-sibling::input")
    })
    private WebElement contactDepartmentTextField;

    @FindAll({
            @FindBy(id = "con7"),
            @FindBy(xpath = "//span[text()='Birthdate']/parent::label/following-sibling::div/child::input")
    })
    private WebElement contactBirthdateTextField;
    @FindAll({
            @FindBy(id = "con9"),
            @FindBy(xpath = "//span[text()='Lead Source']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement contactLeadSource;
    @FindAll({
            @FindBy(id = "con10"),
            @FindBy(xpath = "//span[text()='Phone']/parent::label/following-sibling::input")
    })
    private WebElement contactPhoneTextField;

    @FindAll({
            @FindBy(id = "con13"),
            @FindBy(xpath = "//span[text()='Home Phone']/parent::label/following-sibling::input")
    })
    private WebElement contactHomePhoneTextField;

    @FindAll({
            @FindBy(id = "con12"),
            @FindBy(xpath = "//span[text()='Mobile']/parent::label/following-sibling::input")
    })
    private WebElement contactMobileTextField;

    @FindAll({
            @FindBy(id = "con14"),
            @FindBy(xpath = "//span[text()='Other Phone']/parent::label/following-sibling::input")
    })
    private WebElement contactOtherPhoneTextField;

    @FindAll({
            @FindBy(id = "con11"),
            @FindBy(xpath = "//span[text()='Fax']/parent::label/following-sibling::input")
    })
    private WebElement contactFaxTextField;

    @FindAll({
            @FindBy(id = "con15"),
            @FindBy(xpath = "//span[text()='Email']/parent::label/following-sibling::input")
    })
    private WebElement contactEmailTextField;

    @FindAll({
            @FindBy(id = "con16"),
            @FindBy(xpath = "//span[text()='Assistant']/parent::label/following-sibling::input")
    })
    private WebElement contactAssistantTextField;

    @FindAll({
            @FindBy(id = "con17"),
            @FindBy(xpath = "//span[text()='Asst. Phone']/parent::label/following-sibling::input")
    })
    private WebElement contactAssistantPhoneTextField;

    //Address information
    @FindAll({
            @FindBy(id = "con19street"),
            @FindBy(xpath = "//span[text()='Mailing Street']/parent::label/following-sibling::textarea")
    })
    private WebElement contactMailingStreetTextField;

    @FindAll({
            @FindBy(id = "con18street"),
            @FindBy(xpath = "//span[text()='Other Street']/parent::label/following-sibling::textarea")
    })
    private WebElement contactOtherStreetTextField;

    @FindAll({
            @FindBy(id = "con19city"),
            @FindBy(xpath = "//span[text()='Mailing City']/parent::label/following-sibling::input")
    })
    private WebElement contactMailingCityTextField;
    @FindAll({
            @FindBy(id = "con19state"),
            @FindBy(xpath = "//span[text()='Mailing State/Province']/parent::label/following-sibling::input")
    })
    private WebElement contactMailingStateTextField;
    @FindAll({
            @FindBy(id = "con18city"),
            @FindBy(xpath = "//span[text()='Other City']/parent::label/following-sibling::input")
    })
    private WebElement contactOtherCityTextField;

    @FindAll({
            @FindBy(id = "con18state"),
            @FindBy(xpath = "//span[text()='Other State/Province']/parent::label/following-sibling::input")
    })
    private WebElement contactOtherStateTextField;

    @FindAll({
            @FindBy(id = "con19zip"),
            @FindBy(xpath = "//span[text()='Mailing Zip/Postal Code']/parent::label/following-sibling::input")
    })
    private WebElement contactMailingZipTextField;
    @FindAll({
            @FindBy(id = "con19country"),
            @FindBy(xpath = "//span[text()='Mailing Country']/parent::label/following-sibling::input")
    })
    private WebElement contactMailingCountryTextField;

    @FindAll({
            @FindBy(id = "con18zip"),
            @FindBy(xpath = "//span[text()='Other Zip/Postal Code']/parent::label/following-sibling::input")
    })
    private WebElement contactOtherZipTextField;

    @FindAll({
            @FindBy(id = "con18country"),
            @FindBy(xpath = "//span[text()='Other Country']/parent::label/following-sibling::input")
    })
    private WebElement contactOtherCountryTextField;

    //Additional Information
    @FindAll({
            @FindBy(xpath = "//label[text()='Languages']/parent::td/following-sibling::td/child::input"),
            @FindBy(xpath = "//span[text()='Languages']/parent::label/following-sibling::input")
    })
    private WebElement contactLanguagesTextField;
    @FindAll({
            @FindBy(xpath = "//label[text()='Level']/parent::td/following-sibling::td/child::span/child::select"),
            @FindBy(xpath = "//span[text()='Level']/parent::span/following-sibling::div/descendant::a")
    })
    private WebElement contactLevel;

    //Description Information
    @FindAll({
            @FindBy(id = "con20"),
            @FindBy(xpath = "//span[text()='Description']/parent::label/following-sibling::textarea")
    })
    private WebElement contactDescriptionTextField;

    /**
     * Method to set contactName attribute.
     *
     * @param contactName string value.
     */
    private void setContactNameTextField(final String contactName) {
        CommonWebActions.setTextElement(this.contactNameTextField, contactName);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactLastName string value.
     */
    private void setContactLastNameTextField(final String contactLastName) {

        CommonWebActions.setTextElement(this.contactLastNameTextField, contactLastName);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactTitleTextField string value.
     */
    private void setContactTitleTextField(final String contactTitleTextField) {
        CommonWebActions.setTextElement(this.contactTitleTextField, contactTitleTextField);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactDepartmentTextField string value.
     */
    private void setContactDepartmentTextField(final String contactDepartmentTextField) {
        CommonWebActions.setTextElement(this.contactDepartmentTextField, contactDepartmentTextField);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactBirthdateTextField string value.
     */
    private void setContactBirthdateTextField(final String contactBirthdateTextField) {
        CommonWebActions.setTextElement(this.contactBirthdateTextField, contactBirthdateTextField);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactPhoneTextField string value.
     */
    private void setContactPhoneTextField(final String contactPhoneTextField) {
        CommonWebActions.setTextElement(this.contactPhoneTextField, contactPhoneTextField);
    }

    /**
     * Method to set contact las Name attribute.
     *
     * @param contactHomePhoneTextField string value.
     */
    private void setContactHomePhoneTextField(final String contactHomePhoneTextField) {
        CommonWebActions.setTextElement(this.contactHomePhoneTextField, contactHomePhoneTextField);
    }

    /**
     * Method to set contact assistant attribute.
     *
     * @param assistantTextField string value.
     */
    private void setContactAssistantTextField(final String assistantTextField) {
        CommonWebActions.setTextElement(contactAssistantTextField, assistantTextField);
    }

    /**
     * Method to set contact fax attribute.
     *
     * @param faxTextField string value.
     */
    private void setContactFaxTextField(final String faxTextField) {
        CommonWebActions.setTextElement(contactFaxTextField, faxTextField);
    }

    /**
     * Method to set contact other Phone attribute.
     *
     * @param otherPhoneTextField string value.
     */
    private void setContactOtherPhoneTextField(final String otherPhoneTextField) {
        CommonWebActions.setTextElement(contactOtherPhoneTextField, otherPhoneTextField);
    }

    /**
     * Method to set contact Mobile attribute.
     *
     * @param contactMobileTextField string value.
     */
    private void setContactMobileTextField(final String contactMobileTextField) {
        CommonWebActions.setTextElement(this.contactMobileTextField, contactMobileTextField);
    }

    /**
     * Method to set contact Email attribute.
     *
     * @param contactEmailTextField string value.
     */
    private void setContactEmailTextField(final String contactEmailTextField) {
        CommonWebActions.setTextElement(this.contactEmailTextField, contactEmailTextField);
    }

    /**
     * Method to set contact Assistant Phone attribute.
     *
     * @param contactAssistantPhoneTextField string value.
     */
    public void setContactAssistantPhoneTextField(final String contactAssistantPhoneTextField) {
        CommonWebActions.setTextElement(this.contactAssistantPhoneTextField, contactAssistantPhoneTextField);
    }

    /**
     * Method to set contact Mailing Street attribute.
     *
     * @param contactMailingStreetTextField string value.
     */
    public void setContactMailingStreetTextField(final String contactMailingStreetTextField) {
        CommonWebActions.setTextElement(this.contactMailingStreetTextField, contactMailingStreetTextField);
    }

    /**
     * Method to set contact Other Street attribute.
     *
     * @param contactOtherStreetTextField string value.
     */
    private void setContactOtherStreetTextField(final String contactOtherStreetTextField) {
        CommonWebActions.setTextElement(this.contactOtherStreetTextField, contactOtherStreetTextField);
    }

    /**
     * Method to set contact Mailing City attribute.
     *
     * @param contactMailingCityTextField string value.
     */
    private void setContactMailingCityTextField(final String contactMailingCityTextField) {
        CommonWebActions.setTextElement(this.contactMailingCityTextField, contactMailingCityTextField);
    }

    /**
     * Method to set contact Other City attribute.
     *
     * @param contactOtherCityTextField string value.
     */
    private void setContactOtherCityTextField(final String contactOtherCityTextField) {
        CommonWebActions.setTextElement(this.contactOtherCityTextField, contactOtherCityTextField);
    }

    /**
     * Method to set contact Mailing State attribute.
     *
     * @param contactMailingStateTextField string value.
     */
    public void setContactMailingStateTextField(final String contactMailingStateTextField) {
        CommonWebActions.setTextElement(this.contactMailingStateTextField, contactMailingStateTextField);
    }

    /**
     * Method to set contact Other State attribute.
     *
     * @param contactOtherStateTextField string value.
     */
    private void setContactOtherStateTextField(final String contactOtherStateTextField) {
        CommonWebActions.setTextElement(this.contactOtherStateTextField, contactOtherStateTextField);
    }

    /**
     * Method to set contact Mailing Zip attribute.
     *
     * @param contactMailingZipTextField string value.
     */
    private void setContactMailingZipTextField(final String contactMailingZipTextField) {
        CommonWebActions.setTextElement(this.contactMailingZipTextField, contactMailingZipTextField);
    }

    /**
     * Method to set contact Other Zip attribute.
     *
     * @param contactOtherZipTextField string value.
     */
    private void setContactOtherZipTextField(final String contactOtherZipTextField) {
        CommonWebActions.setTextElement(this.contactOtherZipTextField, contactOtherZipTextField);
    }

    /**
     * Method to set contact Mailing Country attribute.
     *
     * @param contactMailingCountryTextField string value.
     */
    private void setContactMailingCountryTextField(final String contactMailingCountryTextField) {
        CommonWebActions.setTextElement(this.contactMailingCountryTextField, contactMailingCountryTextField);
    }

    /**
     * Method to set contact Other Country attribute.
     *
     * @param contactOtherCountryTextField string value.
     */
    private void setContactOtherCountryTextField(final String contactOtherCountryTextField) {
        CommonWebActions.setTextElement(this.contactOtherCountryTextField, contactOtherCountryTextField);
    }

    /**
     * Method to set contact language attribute.
     *
     * @param contactLanguagesTextField string value.
     */
    private void setContactLanguagesTextField(final String contactLanguagesTextField) {
        CommonWebActions.setTextElement(this.contactLanguagesTextField, contactLanguagesTextField);
    }

    /**
     * Method to set contact Description attribute.
     *
     * @param contactDescriptionTextField string value.
     */
    private void setContactDescriptionTextField(final String contactDescriptionTextField) {
        CommonWebActions.setTextElement(this.contactDescriptionTextField, contactDescriptionTextField);
    }

    /**
     * Method to set contact Salutation attribute.
     *
     * @param contactSalutation string value.
     */
    public void setContactSalutation(final String contactSalutation) {
        CommonActions.selectOnComboBox(this.contactSalutation, contactSalutation);
    }

    /**
     * Method to set contact Lead attribute.
     *
     * @param contactLeadSource string value.
     */
    public void setContactLeadSource(final String contactLeadSource) {
        CommonActions.selectOnComboBox(this.contactLeadSource, contactLeadSource);
    }

    /**
     * Method to set contact Level attribute.
     *
     * @param contactLevel string value.
     */
    public void setContactLevel(final String contactLevel) {
        CommonActions.selectOnComboBox(this.contactLevel, contactLevel);
    }

    /**
     * @param values contact field
     * @return map of contact fields.
     */
    public Map<ContactInputs, Value> getStrategyStepMap(final Map<ContactInputs, String> values) {
        EnumMap<ContactInputs, Value> strategyMap = new EnumMap<>(ContactInputs.class);
        strategyMap.put(ContactInputs.CONTACT_SALUTATION, () ->
                this.setContactSalutation(String.valueOf(values.get(ContactInputs.CONTACT_SALUTATION))));
        strategyMap.put(ContactInputs.CONTACT_NAME, () ->
                this.setContactNameTextField(String.valueOf(values.get(ContactInputs.CONTACT_NAME))));
        strategyMap.put(ContactInputs.CONTACT_LAST_NAME, () ->
                this.setContactLastNameTextField(String.valueOf(values.get(ContactInputs.CONTACT_LAST_NAME))));
        strategyMap.put(ContactInputs.CONTACT_TITLE, () ->
                this.setContactTitleTextField(String.valueOf(values.get(ContactInputs.CONTACT_TITLE))));
        strategyMap.put(ContactInputs.CONTACT_DEPARTMENT, () ->
                this.setContactDepartmentTextField(String.valueOf(values.get(ContactInputs.CONTACT_DEPARTMENT))));
        strategyMap.put(ContactInputs.CONTACT_BIRTHDAY, () ->
                this.setContactBirthdateTextField(String.valueOf(values.get(ContactInputs.CONTACT_BIRTHDAY))));
        strategyMap.put(ContactInputs.CONTACT_PHONE, () ->
                this.setContactPhoneTextField(String.valueOf(values.get(ContactInputs.CONTACT_PHONE))));
        strategyMap.put(ContactInputs.CONTACT_HOME_PHONE, () ->
                this.setContactHomePhoneTextField(String.valueOf(values.get(ContactInputs.CONTACT_HOME_PHONE))));
        strategyMap.put(ContactInputs.CONTACT_MOBILE, () ->
                this.setContactMobileTextField(String.valueOf(values.get(ContactInputs.CONTACT_MOBILE))));
        strategyMap.put(ContactInputs.CONTACT_OTHER_PHONE, () ->
                this.setContactOtherPhoneTextField(String.valueOf(values.get(ContactInputs.CONTACT_OTHER_PHONE))));
        strategyMap.put(ContactInputs.CONTACT_FAX, () ->
                this.setContactFaxTextField(String.valueOf(values.get(ContactInputs.CONTACT_FAX))));
        strategyMap.put(ContactInputs.CONTACT_EMAIL, () ->
                this.setContactEmailTextField(String.valueOf(values.get(ContactInputs.CONTACT_EMAIL))));
        strategyMap.put(ContactInputs.CONTACT_ASSISTANT, () ->
                this.setContactAssistantTextField(String.valueOf(values.get(ContactInputs.CONTACT_ASSISTANT))));
        strategyMap.put(ContactInputs.CONTACT_ASST_PHONE, () ->
                this.setContactAssistantPhoneTextField(String.valueOf(values.get(ContactInputs.CONTACT_ASST_PHONE))));
        strategyMap.put(ContactInputs.CONTACT_LEAD_SOURCE, () ->
                this.setContactLeadSource(String.valueOf(values.get(ContactInputs.CONTACT_LEAD_SOURCE))));
        strategyMap.put(ContactInputs.CONTACT_MAILING_STREET, () ->
                this.setContactMailingStreetTextField(String.valueOf(
                        values.get(ContactInputs.CONTACT_MAILING_STREET))));
        strategyMap.put(ContactInputs.CONTACT_OTHER_STREET, () ->
                this.setContactOtherStreetTextField(String.valueOf(values.get(ContactInputs.CONTACT_OTHER_STREET))));
        strategyMap.put(ContactInputs.CONTACT_MAILING_CITY, () ->
                this.setContactMailingCityTextField(String.valueOf(values.get(ContactInputs.CONTACT_MAILING_CITY))));
        strategyMap.put(ContactInputs.CONTACT_OTHER_CITY, () ->
                this.setContactOtherCityTextField(String.valueOf(values.get(ContactInputs.CONTACT_OTHER_CITY))));
        strategyMap.put(ContactInputs.CONTACT_MAILING_STATE, () ->
                this.setContactMailingStateTextField(String.valueOf(values.get(ContactInputs.CONTACT_MAILING_STATE))));
        strategyMap.put(ContactInputs.CONTACT_OTHER_STATE, () ->
                this.setContactOtherStateTextField(String.valueOf(values.get(ContactInputs.CONTACT_OTHER_STATE))));
        strategyMap.put(ContactInputs.CONTACT_MAILING_ZIP, () ->
                this.setContactMailingZipTextField(String.valueOf(values.get(ContactInputs.CONTACT_MAILING_ZIP))));
        strategyMap.put(ContactInputs.CONTACT_OTHER_ZIP, () ->
                this.setContactOtherZipTextField(String.valueOf(values.get(ContactInputs.CONTACT_OTHER_ZIP))));
        strategyMap.put(ContactInputs.CONTACT_MAILING_COUNTRY, () ->
                this.setContactMailingCountryTextField(String.valueOf(
                        values.get(ContactInputs.CONTACT_MAILING_COUNTRY))));
        strategyMap.put(ContactInputs.CONTACT_OTHER_COUNTRY, () ->
                this.setContactOtherCountryTextField(String.valueOf(values.get(ContactInputs.CONTACT_OTHER_COUNTRY))));
        strategyMap.put(ContactInputs.CONTACT_LANGUAGES, () ->
                this.setContactLanguagesTextField(String.valueOf(values.get(ContactInputs.CONTACT_LANGUAGES))));
        strategyMap.put(ContactInputs.CONTACT_LEVEL, () ->
                this.setContactLevel(String.valueOf(values.get(ContactInputs.CONTACT_LEVEL))));
        strategyMap.put(ContactInputs.CONTACT_DESCRIPTION, () ->
                this.setContactDescriptionTextField(String.valueOf(values.get(ContactInputs.CONTACT_DESCRIPTION))));

        return strategyMap;
    }

    /**
     * getSaveNewAccountButton.
     */
    @Override
    public void getSaveNewAccountButton() {
        CommonWebActions.clickElement(this.saveNewAccountButton);
    }

}
