package org.fundacionjala.sfdc.pageobjects.Accounts;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceConnection;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * SFADetailsPage.java
 * Class that represents the page where details of an account are displayed.
 */
public class SFADetailsPage extends SalesForceConnection {
    private WebDriverWait wait;

    @FindBy(how = How.CSS, using = "#topButtonRow.pbButton > input[name='edit']")
    private WebElement editButton;

    @FindBy(how = How.CSS, using = "#topButtonRow.pbButton > input[name='delete']")
    private WebElement deleteButton;

    @FindBy(how = How.CLASS_NAME, using = "topName")
    private WebElement newAccountLabel;

    /**
     * Constructor.
     */
    public SFADetailsPage() {
        super();
        PageFactory.initElements(this.webDriver, this);
    }

    /**
     * Method to get edit button.
     * @return the edit button as WebElement.
     */
    public WebElement getEditButton() {
        return this.editButton;
    }

    /**
     * Method to get delete button.
     * @return delete button as WebElement.
     */
    public WebElement getDeleteButton() {
        return this.deleteButton;
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
        wait.until(ExpectedConditions.visibilityOf(this.newAccountLabel));
        return this.newAccountLabel.getText();
    }
}
