package org.fundacionjala.sfdc.pageobjects.accounts;

import org.fundacionjala.sfdc.pageobjects.SalesForceConnection;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * SFAMainPage.java
 * Class that represents the main page of accounts section.
 */
public class SFAMainPage extends SalesForceConnection {

    @FindBy(how = How.CSS, using = ".pbButton > input[title='New']")
    private WebElement newAccountButton;

    @FindBy(how = How.CSS, using = "tr.dataRow.even.first.dataRow >th[scope='row'] > a")
    private WebElement lastAccountLink;

    @FindBy(how = How.CSS, using = "h2.pageDescription")
    private WebElement homeContact;

    /**
     * Constructor.
     */
    public SFAMainPage() {
        super();
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }

    /**
     * Getter of newAccountButton.
     * @return button.
     */
    public WebElement getNewAccountButton() {
        return CommonActions.getElement(this.newAccountButton);
    }

    /**
     * Getter of last account displayed in account's list.
     * @return the link of the last account.
     */
    public WebElement getAccountNameLink() {
        return CommonActions.getElement(this.lastAccountLink);
    }

    /**
     * Method to know if the page of new account is displayed.
     * @return true or false.
     */
    public boolean isNewAccountButtonDisplayed() {
        return CommonActions.getElement(this.newAccountButton).isDisplayed();
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
    public String getAccountHomePage() {
        return CommonActions.getElement(this.homeContact).getText();
    }
}
