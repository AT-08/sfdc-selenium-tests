package org.fundacionjala.sfdc.pageobjects.components;

import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Top menu of lightning SL.
 */
public class TopMenuLightning extends TopMenu {
    @FindBy(css = ".branding-user-profile")
    private WebElement userProfileLink;

    @FindBy(css = "div.profile-card-footer > a")
    private WebElement switchThemeLink;

    @Override
    public void switchTheme() {
        CommonActions.clickElement(userProfileLink);
        CommonActions.clickElement(switchThemeLink);
    }

}
