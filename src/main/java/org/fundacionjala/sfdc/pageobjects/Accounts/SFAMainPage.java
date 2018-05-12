package org.fundacionjala.sfdc.pageobjects.Accounts;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * SFAMainPage.java
 * Class that represents the main page of accounts section.
 */
public class SFAMainPage extends SalesForceConnection{
    private WebDriverWait wait;
    private By newAccountButton;
    private By lastAccountLink;
    private By homeContact;

    /**
     * Constructor.
     */
    public SFAMainPage() {
        super();
        this.newAccountButton = By.cssSelector(".pbButton > input[title='New']");
        this.lastAccountLink = By.cssSelector("tr.dataRow.even.first.dataRow >th[scope='row'] > a");
        this.homeContact = By.cssSelector("h2.pageDescription");
    }

    /**
     * Getter of newAccountButton.
     * @return button.
     */
    public WebElement getNewAccountButton() {
        return this.webDriver.findElement(this.newAccountButton);
    }

    /**
     * Getter of last account displayed in account's list.
     * @return the link of the last account.
     */
    public WebElement getAccountNameLink() {
        return this.webDriver.findElement(this.lastAccountLink);
    }

    /**
     * Method to know if the page of new account is displayed.
     * @return true or false.
     */
    public boolean isNewAccountButtonDisplayed() {
        return this.webDriver.findElement(this.newAccountButton).isDisplayed();
    }

    /**
     * Method to click on new button.
     */
    public void clickNewAccountButton() {
        getNewAccountButton().click();
    }

    /**
     * Method to click on last account's link.
     */
    public void clickAccountNameLink() {
        getAccountNameLink().click();
    }

    /**
     * Method to get Home menu option text. It is used to verify an account was deleted.
     * @return the first menu option text.
     */
    public String accountHomePage() {
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.homeContact));
        return this.webDriver.findElement(this.homeContact).getText();
    }
}
