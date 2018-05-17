package org.fundacionjala.sfdc.pageobjects.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Lightning home page SL.
 */
public class HomePageLightning extends HomePage {

    @FindBy(css = "ul.slds-has-flexi-truncate>li:first-child")
    private WebElement homeTab;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        System.out.println("Construction.");
    }

    @Override
    public boolean isInHomePage() {
        return homeTab.isDisplayed();
    }
}
