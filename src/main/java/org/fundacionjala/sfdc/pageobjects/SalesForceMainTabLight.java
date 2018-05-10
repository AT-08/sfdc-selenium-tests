package org.fundacionjala.sfdc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalesForceMainTabLight implements SalesForceMainTab {
    private WebDriver webDriver;
    private By launcherButton;
    private By moduleLink;

    public SalesForceMainTabLight (final WebDriver webDriver, String url) {
        this.webDriver = webDriver;
        this.launcherButton = By.cssSelector(".salesforceIdentityAppLauncherHeader");
        this.moduleLink = By.linkText(url);
    }
    @Override
    public WebElement getTabButton() {
        return this.webDriver.findElement(launcherButton);
    }
    @Override
    public WebElement getAccountsLink() {
        return this.webDriver.findElement(moduleLink);
    }
    @Override
    public void clickTabButton(final WebElement button) {
        button.click();
    }
    @Override
    public void clickAccountsLink(final WebElement link) {
        link.click();
    }



    @Override
    public void displayOptions() {
        WebElement button = getTabButton();
        clickTabButton(button);
    }

    /**
     * Method to click on Accounts.
     */
    @Override
    public void goToAccounts() {
        WebElement link = getAccountsLink();
        clickAccountsLink(link);
        closeMessageLighting();
    }

    @Override
    public void closeMessageLighting() {

    }


}
