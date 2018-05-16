package org.fundacionjala.sfdc.pageobjects.contacts;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceConnection;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * SFCDetailsPage.java
 * Class that represents the page where details of an contact are displayed.
 */
public class SFCDetailsPage extends SalesForceConnection {
    public static final WebDriverWait WAITER = DriverManager.getInstance().getWaiter();

    @FindBy(how = How.CSS, using = "#topButtonRow > input[name='edit']")
    private WebElement editContactButton;

    @FindBy(how = How.CSS, using = "#topButtonRow > input[name='del']")
    private WebElement deleteContactButton;

    @FindBy(how = How.CLASS_NAME, using = "topName")
    private WebElement newContactLabel;

    /**
     * Method to get "edit" button.
     *
     * @return web element edit button.
     */
    public WebElement getEditButton() {
        return CommonActions.getElement(this.editContactButton);
    }

    /**
     * Method to get "delete" selected contact.
     *
     * @return delete button.
     */
    public WebElement getDeleteButton() {
        return CommonActions.getElement(this.deleteContactButton);
    }

    /**
     * Method to know if an account is saved.
     *
     * @return the new contact name displayed in label.
     */
    public String newContactSavedName() {
        return CommonActions.getElement(this.newContactLabel).getText();
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
        Alert alert = WAITER.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    /**
     * Method to do click "edit" button.
     */
    public void clickEditContact() {
        getEditButton().click();
    }
}
