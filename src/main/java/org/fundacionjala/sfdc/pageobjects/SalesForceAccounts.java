package org.fundacionjala.sfdc.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * SalesForceAccounts.java
 * Class that represents Accounts page in SalesForce.
 */
public class SalesForceAccounts {
    private WebDriver webDriver;
    private By newAccountButton;
    private By accountNameTextField;
    private By saveNewAccountButton;
    private By newAccountLabel;

    /**
     * Constructor.
     * @param webDriver instance.
     */
    public SalesForceAccounts(final WebDriver webDriver) {
        this.webDriver = webDriver;
        this.newAccountButton = By.cssSelector(".pbButton > input[title='New']");
        this.accountNameTextField = By.cssSelector(".requiredInput > input[name='acc2']");
        this.saveNewAccountButton = By.cssSelector(".pbButton > input[name='save']");
        this.newAccountLabel = By.cssSelector(".topName");
    }

    /**
     * Getter of newAccountButton.
     * @return button.
     */
    public WebElement getNewAccountButton() {
        return this.webDriver.findElement(this.newAccountButton);
    }

    /**
     * Getter of saveNewAccountButton.
     * @return button.
     */
    public WebElement getSaveNewAccountButton() {
        return this.webDriver.findElement(this.saveNewAccountButton);
    }

    /**
     * Method to click button.
     * @param button to click.
     */
    public void clickNewAccountButton(final WebElement button) {
        button.click();
    }

    /**
     * Method to click button.
     * @param button to click.
     */
    public void clickSaveNewAccountButton(final WebElement button) {
        button.click();
    }

    /**
     * Method to set accountName attribute.
     * @param accountName string value.
     */
    public void setAccountNameTextField(final String accountName) {
        webDriver.findElement(this.accountNameTextField).sendKeys(accountName);
    }

    /**
     * Method to know if the page of new account is displayed.
     * @return true or false.
     */
    public boolean isNewAccountButtonDisplayed() {
        return this.webDriver.findElement(this.newAccountButton).isDisplayed();
    }

    /**
     * Method to create a new account.
     * @param accountName the account name.
     */
    public void createNewAccount(final String accountName) {
        WebElement button = getNewAccountButton();
        clickNewAccountButton(button);
        setAccountNameTextField(accountName);
    }

    /**
     * Method to know if an account is saved.
     * @return the new account name displayed in label.
     */
    public String newAccountSavedName() {
        return this.webDriver.findElement(this.newAccountLabel).getText();
    }
}

