package org.fundacionjala.sfdc.pageobjects.Home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageClassic extends HomePage {
    @FindBy(css = "#home_Tab")
    private WebElement homeTab;

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }

    @Override
    public boolean isInHomePage() {
        return homeTab.isDisplayed();
    }
}
