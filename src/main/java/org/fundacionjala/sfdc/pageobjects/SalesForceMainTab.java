package org.fundacionjala.sfdc.pageobjects;

import org.openqa.selenium.WebElement;

public interface SalesForceMainTab {
    WebElement getTabButton();

    WebElement getAccountsLink();

    void clickTabButton(WebElement button);

    void clickAccountsLink(WebElement link);

    void displayOptions();

    void goToAccounts();

    void closeMessageLighting();
}
