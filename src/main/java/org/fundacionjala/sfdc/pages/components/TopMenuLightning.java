package org.fundacionjala.sfdc.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.core.ui.CommonWebActions;

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
        CommonWebActions.jsClickElement(userProfileLink);
        CommonWebActions.jsClickElement(switchThemeLink);
    }

}
