package org.fundacionjala.sfdc.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.core.ui.driver.DriverManager;

/**
 * Top menu of classic SL.
 */
public class TopMenuClassic extends TopMenu {
    @FindBy(id = "userNavLabel")
    private WebElement userProfileLink;

    @FindBy(css = "a[class='switch-to-lightning']")
    private WebElement switchThemeLink;

    @Override
    public void switchTheme() {
        action.click(userProfileLink);
        action.click(switchThemeLink);
    }

    /**
     * Wait until profile link is visible.
     */
    public void waitUntilPageObjectIsLoaded() {
        DriverManager.getInstance().getWaiter().until(ExpectedConditions.visibilityOf(userProfileLink));
    }
}
