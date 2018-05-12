package org.fundacionjala.sfdc.pageobjects.Accounts;

import org.fundacionjala.sfdc.pageobjects.SalesForceConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * SFANewModifyPage.java
 * Class that represents the form where you fill fields in order to create or modify an account.
 */
public class SFANewModifyPage extends SalesForceConnection{
    private By accountNameTextField;
    private By saveNewAccountButton;

    /**
     * Constructor.
     */
    public SFANewModifyPage() {
        super();
        this.accountNameTextField = By.cssSelector(".requiredInput > input[name='acc2']");
        this.saveNewAccountButton = By.cssSelector(".pbButton > input[name='save']");
    }

    /**
     * Getter of saveNewAccountButton.
     * @return button.
     */
    public WebElement getSaveNewAccountButton() {
        return this.webDriver.findElement(this.saveNewAccountButton);
    }

    /**
     * Method to set accountName attribute.
     * @param accountName string value.
     */
    public void setAccountNameTextField(final String accountName) {
        webDriver.findElement(this.accountNameTextField).sendKeys(accountName);
    }

    /**
     * Method to click button.
     */
    public void clickSaveNewAccountButton() {
        getSaveNewAccountButton().click();
    }
}
