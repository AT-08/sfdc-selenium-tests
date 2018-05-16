package org.fundacionjala.sfdc.pageobjects.accounts;

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
 * SFADetailsPage.java
 * Class that represents the page where details of an account are displayed.
 */
public class SFADetailsPage extends SalesForceConnection {
    public static final WebDriverWait WAITER = DriverManager.getInstance().getWaiter();

    @FindBy(how = How.CSS, using = "#topButtonRow.pbButton > input[name='edit']")
    private WebElement editButton;

    @FindBy(how = How.CSS, using = "#topButtonRow.pbButton > input[name='delete']")
    private WebElement deleteButton;

    @FindBy(how = How.CLASS_NAME, using = "topName")
    private WebElement newAccountLabel;


    /**
     * Method to get edit button.
     *
     * @return the edit button as WebElement.
     */
    public WebElement getEditButton() {

        // CommonActions.scrollPage(this.webDriver, this.editButton);
        return CommonActions.getElement(this.editButton);
    }

    /**
     * Method to get delete button.
     *
     * @return delete button as WebElement.
     */
    public WebElement getDeleteButton() {
        CommonActions.scrollPage(this.webDriver, this.deleteButton);
        return CommonActions.getElement(this.deleteButton);
    }

    /**
     * Method to click on javascript alert that is displayed to confirm deleting an account.
     */
    public void clickDeleteAlert() {
        Alert alert = WAITER.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    /**
     * Method to know if an account is saved.
     *
     * @return the new account name displayed in label.
     */
    public String getNewAccountSavedName() {
        return CommonActions.getElement(this.newAccountLabel).getText();
    }
}
