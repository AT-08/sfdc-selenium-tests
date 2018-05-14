package org.fundacionjala.sfdc.pageobjects;


import org.fundacionjala.sfdc.commons.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * SalesForceMainTabClassic.java
 * Class of Salesforce main tab that contains all the options.
 */
public class SalesForceMainTabClassic {
    private WebDriver webDriver;
    private By tabButton;
    private By accountsLink;
    private WebDriverWait wait;

    /**
     * Constructor.
     *
     * @param webDriver    instance.
     * @param url          web page.
     * @param actionButton menu button.
     */
    public SalesForceMainTabClassic(final String url, final String actionButton) {

        this.webDriver = DriverManager.getNavigator();
        this.tabButton = By.cssSelector(actionButton);
        this.accountsLink = By.cssSelector(url);

        //this.tabButton = By.id("AllTab_Tab");
        // this.accountsLink = By.linkText(url);
    }

    /**
     * Getter of tabButton.
     *
     * @return the button.
     */
    public WebElement getTabButton() {
        return this.webDriver.findElement(this.tabButton);
    }

    /**
     * Getter of accountsLink.
     *
     * @return the link.
     */
    public WebElement getAccountsLink() {
        return this.webDriver.findElement(this.accountsLink);
    }

    /**
     * Method to click tabButton.
     *
     * @param button to click.
     */
    public void clickTabButton(final WebElement button) {
        button.click();
    }

    /**
     * Method to click accountsLink.
     *
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
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.accountsLink));

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
        try {
            if (webDriver.findElement(By.id("lexNoThanks")).isDisplayed()) {
                webDriver.findElement(By.id("lexNoThanks")).click();
                webDriver.findElement(By.id("tryLexDialogX")).click();
            }

        } catch (NoSuchElementException e) {
            e.getMessage();
        }
    }
}
