package org.fundacionjala.sfdc.pageobjects;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.fundacionjala.sfdc.commons.DriverManager;

/**
 * SalesForceAccounts.java
 * Class that represents Accounts page in SalesForce.
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
        this.contactLastNameTextField = By.id("name_lastcon2");
        this.newContactButton = By.cssSelector("input[name='new']");
        this.saveContactButton = By.cssSelector("#topButtonRow> input[name='save']");
        this.editContactButton = By.cssSelector("#topButtonRow > input[name='edit']");
        this.deleteContactButton = By.cssSelector("#topButtonRow > input[name='del']");
        this.newContactLabel = By.className("topName");
        this.homeContact = By.cssSelector("h2.pageDescription");
        this.lastContactLink = By.cssSelector("tr.dataRow.even.first.dataRow >th[scope='row'] > a");
    }



    public void clickNewButton(final WebElement button) {
        button.click();
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.contactNameTextField));
    }
    public void clickEditContact() {
        getEditButton().click();
    }

    public WebElement getNewButton() {
        return this.webDriver.findElement(this.newContactButton);
    }
    public WebElement getEditButton() {
        return this.webDriver.findElement(this.editContactButton);
    }

    public WebElement getSaveContactButton() {
        return this.webDriver.findElement(this.saveContactButton);
    }

    public void clickSaveContactButton(final WebElement button) {
        button.click();
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.editContactButton));
    }

    /**
     * Method to click edit link.
     */
    public void editContact(String contactName) {
        setContactNameTextField(contactName);
    }

    /**
     * Method to create a new account.
     * @param contactName the account name.
     */
    public void fillInfoNewContact(final String contactName, final String contactLastName) {
        //WebElement button = getNewAccountButton();
        //clickNewAccountButton(button);
        setContactNameTextField(contactName);
        setContactLastNameTextField(contactLastName);
       // WebElement button = getSaveContactButton();
       // clickSaveContactButton(button);

    }

    /**
     * Method to set accountName attribute.
     * @param contactName string value.
     */
    public void setContactNameTextField(final String contactName) {
        webDriver.findElement(this.contactNameTextField).sendKeys(contactName);
    }


    /**
     * Method to set accountName attribute.
     * @param contactLastName string value.
     */
    public void setContactLastNameTextField(final String contactLastName) {
        webDriver.findElement(this.contactLastNameTextField).sendKeys(contactLastName);
    }

    /**
     * Method to know if an account is saved.
     * @return the new account name displayed in label.
     */
    public String newContactSavedName() {
        return this.webDriver.findElement(this.newContactLabel).getText();
    }

    public String contactHomePage() {
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.homeContact));

        return this.webDriver.findElement(this.homeContact).getText();
    }

    public void clickContactNameLink() {
        getContactNameLink().click();
    }
    public WebElement getContactNameLink() {
        return this.webDriver.findElement(this.lastContactLink);
    }

    public WebElement getDeleteButton() {
        return this.webDriver.findElement(this.deleteContactButton);
    }

    public void clickDeleteContact() {
        getDeleteButton().click();
    }

    public void clickDeleteAlert() {
        wait = DriverManager.getInstance().getWaiter();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

}

