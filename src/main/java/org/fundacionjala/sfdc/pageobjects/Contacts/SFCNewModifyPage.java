package org.fundacionjala.sfdc.pageobjects.Contacts;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceConnection;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SFCNewModifyPage extends SalesForceConnection {
    private WebDriverWait wait;
    @FindBy(how = How.ID, using = "name_firstcon2")
    private WebElement contactNameTextField;

    @FindBy(how = How.ID, using = "name_lastcon2")
    private WebElement contactLastNameTextField;

    @FindBy(how = How.CSS, using = "#topButtonRow> input[name='save']")
    private WebElement saveContactButton;

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
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOf(this.saveContactButton));
        return this.saveContactButton;
    }


    /**
     * Method to set contactName attribute.
     * @param contactName string value.
     */
    public void setContactNameTextField(final String contactName) {
        this.contactNameTextField.sendKeys(contactName);
    }

    /**
     * Method to set contact las Name attribute.
     * @param contactLastName string value.
     */
    public void setContactLastNameTextField(final String contactLastName) {
        this.contactLastNameTextField.sendKeys(contactLastName);
    }

    /**
     * Method to edit contact fields.
     * @param contactName the contact name.
     */
    public void editContact(final String contactName) {
        setContactNameTextField(contactName);
    }

    /**
     * Method to create a new contact.
     * @param contactName the contact name.
     * @param contactLastName the contact name.
     */
    public void fillInfoNewContact(final String contactName, final String contactLastName) {
        setContactNameTextField(contactName);
        setContactLastNameTextField(contactLastName);
    }

    /**
     * Method to do click "save" button.
     */
    public void clickSaveContactButton() {
        getSaveContactButton().click();

    }



}
