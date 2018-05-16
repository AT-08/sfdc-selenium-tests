package org.fundacionjala.sfdc.pageobjects.Home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLightning extends HomePage {

    @FindBy(css = "li.slds-context-bar__item:nth-child(2) > a:nth-child(1)")
    private WebElement homeTab;

    @Override
    public void waitUntilPageObjectIsLoaded() {
    }

    @Override
    public boolean isInHomePage() {
        return homeTab.isDisplayed();
    }
}
