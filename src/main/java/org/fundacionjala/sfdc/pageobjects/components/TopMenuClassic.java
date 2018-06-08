package org.fundacionjala.sfdc.pageobjects.components;

import org.fundacionjala.sfdc.util.CommonActions;
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
        CommonActions.clickElement(userProfileLink);
        CommonActions.clickElement(switchThemeLink);
    }

    /**
     * Wait until profile link is visible.
     */
    public void waitUntilPageObjectIsLoaded() {
        driverWait.until(ExpectedConditions.visibilityOf(userProfileLink));
    }
}
