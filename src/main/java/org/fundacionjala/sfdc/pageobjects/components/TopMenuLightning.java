package org.fundacionjala.sfdc.pageobjects.components;

import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.core.util.CommonWebActions.jsClickElement;

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
        jsClickElement(userProfileLink);
        jsClickElement(switchThemeLink);
    }

}
