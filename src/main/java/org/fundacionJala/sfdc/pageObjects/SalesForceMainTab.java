package org.fundacionJala.sfdc.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * SalesForceMainTab.java
 * Class of Salesforce main tab that contains all the options.
 */
public class SalesForceMainTab {
    private WebDriver webDriver;
    private By tabButton;
    private By accountsLink;

    /**
     * Constructor.
     * @param webDriver instance.
     */
    public SalesForceMainTab(final WebDriver webDriver) {
        this.webDriver = webDriver;
        this.tabButton = By.id("AllTab_Tab");
        this.accountsLink = By.linkText("Accounts");
    }

    /**
     * Getter of tabButton.
     * @return the button.
     */
    public WebElement getTabButton() {
        return this.webDriver.findElement(this.tabButton);
    }

    /**
     * Getter of accountsLink.
     * @return the link.
     */
    public WebElement getAccountsLink() {
        return this.webDriver.findElement(this.accountsLink);
    }

    /**
     * Method to click tabButton.
     * @param button to click.
     */
    public void clickTabButton(final WebElement button) {
        button.click();
    }

    /**
     * Method to click accountsLink.
     * @param link to click.
     */
    public void clickAccountsLink(final WebElement link) {
        link.click();
    }

    /**
     * Method to display all the options in Salesforce.
     */
    public void displayOptions() {
        WebElement button = getTabButton();
        clickTabButton(button);
    }

    /**
     * Method to click on Accounts.
     */
    public void goToAccounts() {
        WebElement link = getAccountsLink();
        clickAccountsLink(link);
        closeMessageLighting();
    }

    /**
     * Method to close message displayed.
     */
    public void closeMessageLighting() {
        if (webDriver.findElement(By.id("lexNoThanks")).isDisplayed()) {
            webDriver.findElement(By.id("lexNoThanks")).click();
            webDriver.findElement(By.id("tryLexDialogX")).click();
        }
    }
}
