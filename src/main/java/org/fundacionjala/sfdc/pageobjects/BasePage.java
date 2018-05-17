package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage.java
 * Class to initialize WebDriver for all pages.
 */
public abstract class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected CommonActions commonActions;

    /**
     * Constructor.
     */
    public BasePage() {
        this.webDriver = DriverManager.getInstance().getNavigator();
        this.wait = DriverManager.getInstance().getWaiter();
        this.commonActions = new CommonActions();
        PageFactory.initElements(webDriver, this);
        waitUntilPageObjectIsLoaded();
    }

    public abstract void waitUntilPageObjectIsLoaded();
}
