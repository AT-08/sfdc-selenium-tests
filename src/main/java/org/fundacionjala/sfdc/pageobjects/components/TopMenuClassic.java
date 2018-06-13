package org.fundacionjala.sfdc.pageobjects.components;

import org.fundacionjala.core.driver.DriverManager;
import org.fundacionjala.core.selenium.CommonWebActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        CommonWebActions.clickElement(userProfileLink);
        CommonWebActions.clickElement(switchThemeLink);
    }

    /**
     * Wait until profile link is visible.
     */
    public void waitUntilPageObjectIsLoaded() {
        DriverManager.getInstance().getWaiter().until(ExpectedConditions.visibilityOf(userProfileLink));
    }
}
