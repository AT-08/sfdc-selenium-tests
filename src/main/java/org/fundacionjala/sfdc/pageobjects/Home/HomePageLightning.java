package org.fundacionjala.sfdc.pageobjects.Home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLightning extends HomePage {

    @FindBy(css = "#oneHeader a[href*=\"#/setup/SetupOneHome/home\"]")
    private WebElement homeTab;

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }

    @Override
    public boolean isInHomePage() {
        return homeTab.isDisplayed();
    }
}
