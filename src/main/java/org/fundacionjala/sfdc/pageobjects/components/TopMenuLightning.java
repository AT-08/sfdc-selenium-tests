package org.fundacionjala.sfdc.pageobjects.components;

import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        CommonActions.jsClickElement(userProfileLink);
        CommonActions.jsClickElement(switchThemeLink);
    }

}
