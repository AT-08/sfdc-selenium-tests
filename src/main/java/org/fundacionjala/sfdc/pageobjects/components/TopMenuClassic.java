package org.fundacionjala.sfdc.pageobjects.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuClassic extends TopMenu {
    @FindBy(id = "#userNavLabel")
    private WebElement userProfileLink;

    @FindBy(id = "")//improve selector
    private WebElement switchThemeLink;

    @Override
    public void switchTheme() {
        commonActions.clickElement(userProfileLink);
        commonActions.clickElement(switchThemeLink);
    }

    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(userProfileLink));
    }
}
