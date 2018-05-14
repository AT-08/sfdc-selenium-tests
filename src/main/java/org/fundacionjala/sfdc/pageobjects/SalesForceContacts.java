package org.fundacionjala.sfdc.pageobjects;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.fundacionjala.sfdc.commons.DriverManager;

/**
 * SalesForceContacts.java
 * Class that represents Contacts page in SalesForce.
 */
public class SalesForceContacts {
    private WebDriver webDriver;
    private By contactNameTextField;
    private By contactLastNameTextField;
    private By newContactButton;
    private By saveContactButton;
    private By editContactButton;
    private By deleteContactButton;
    private WebDriverWait wait;
    private By newContactLabel;
    private By lastContactLink;
    private By homeContact;

    /**
     * Constructor.
     * @param webDriver instance.
     */
    public SalesForceContacts(final WebDriver webDriver) {
        this.webDriver = webDriver;
        this.contactNameTextField = By.id("name_firstcon2");
        this.saveContactButton = By.cssSelector("#topButtonRow> input[name='save']");
        this.contactLastNameTextField = By.id("name_lastcon2");


        this.editContactButton = By.cssSelector("#topButtonRow > input[name='edit']");
        this.deleteContactButton = By.cssSelector("#topButtonRow > input[name='del']");
        this.newContactLabel = By.className("topName");


        this.newContactButton = By.cssSelector("input[name='new']");
        this.homeContact = By.cssSelector("h2.pageDescription");
        this.lastContactLink = By.cssSelector("tr.dataRow.even.first.dataRow >th[scope='row'] > a");
    }

    /**
     * Method to get "edit" button.
     * @return web element edit button.
     */
    public WebElement getEditButton() {
        return this.webDriver.findElement(this.editContactButton);
    }
    /**
     * Method to get "save" button.
     * @return web element save button.
     */
    public WebElement getSaveContactButton() {
        return this.webDriver.findElement(this.saveContactButton);
    }
    /**
     * Method to know if an account is saved.
     * @return the new contact name displayed in label.
     */
    public String newContactSavedName() {
        return this.webDriver.findElement(this.newContactLabel).getText();
    }
    /**
     * Method to know if an account was delete.
     * @return the contact home page.
     */
    public String contactHomePage() {
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.homeContact));
        return this.webDriver.findElement(this.homeContact).getText();
    }

    /**
     * Method to get the last concat name link.
     * @return the last contact.
     */
    public WebElement getContactNameLink() {
        return this.webDriver.findElement(this.lastContactLink);
    }
    /**
     * Method to get "delete" selected contact.
     * @return delete button.
     */
    public WebElement getDeleteButton() {
        return this.webDriver.findElement(this.deleteContactButton);
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
     * Method to set contactName attribute.
     * @param contactName string value.
     */
    public void setContactNameTextField(final String contactName) {
        webDriver.findElement(this.contactNameTextField).sendKeys(contactName);
    }

    /**
     * Method to set contact las Name attribute.
     * @param contactLastName string value.
     */
    public void setContactLastNameTextField(final String contactLastName) {
        webDriver.findElement(this.contactLastNameTextField).sendKeys(contactLastName);
    }
     /**
     * Method to do click "delete" selected contact.
     */
    public void clickDeleteContact() {
        getDeleteButton().click();
    }
    /**
     * Method to do click accept button on the confirm alert before delete contact.
     */
    public void clickDeleteAlert() {
        wait = DriverManager.getInstance().getWaiter();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
    /**
     * Method to do click "new" button.
     * @param button the account name.
     */
    public void clickNewButton(final WebElement button) {
        button.click();
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.contactNameTextField));
    }
    /**
     * Method to do click "edit" button.
     */
    public void clickEditContact() {
        getEditButton().click();
    }
    /**
     * Method to do click "save" button.
     * @param button is the save contact button.
     */
    public void clickSaveContactButton(final WebElement button) {
        button.click();
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.editContactButton));
    }
    /**
     * Method to do click "new" button.
     * @return a new contact button element.
     */
    public WebElement getNewButton() {
        return this.webDriver.findElement(this.newContactButton);
    }
    /**
     * Method to do click "contactHomePage".
     */
    public void clickContactNameLink() {
        getContactNameLink().click();

    }

}

