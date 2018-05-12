package org.fundacionjala.sfdc.pageobjects.Accounts;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceConnection;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * SFADetailsPage.java
 * Class that represents the page where details of an account are displayed.
 */
public class SFADetailsPage extends SalesForceConnection {
    private WebDriverWait wait;
    private By editButton;
    private By deleteButton;
    private By newAccountLabel;

    /**
     * Constructor.
     */
    public SFADetailsPage() {
        super();
        this.editButton = By.cssSelector("#topButtonRow.pbButton > input[name='edit']");
        this.deleteButton = By.cssSelector("#topButtonRow.pbButton > input[name='delete']");
        this.newAccountLabel = By.className("topName");
    }

    /**
     * Method to get edit button.
     * @return the edit button as WebElement.
     */
    public WebElement getEditButton() {
        return this.webDriver.findElement(this.editButton);
    }

    /**
     * Method to get delete button.
     * @return delete button as WebElement.
     */
    public WebElement getDeleteButton() {
        return this.webDriver.findElement(this.deleteButton);
    }

    /**
     * Method to click on edit button.
     */
    public void clickEditAccount() {
        getEditButton().click();
    }

    /**
     * Method to click on delete button.
     */
    public void clickDeleteAccount() {
        getDeleteButton().click();
    }

    /**
     * Method to click on javascript alert that is displayed to confirm deleting an account.
     */
    public void clickDeleteAlert() {
        WebDriverWait wait = DriverManager.getInstance().getWaiter();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    /**
     * Method to know if an account is saved.
     * @return the new account name displayed in label.
     */
    public String getNewAccountSavedName() {
        WebDriverWait wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.newAccountLabel));
        return this.webDriver.findElement(this.newAccountLabel).getText();
    }
}
