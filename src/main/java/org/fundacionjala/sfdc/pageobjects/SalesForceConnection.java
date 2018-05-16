package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * SalesForceConnection.java
 * Class to initialize WebDriver for all pages.
 */
public abstract class SalesForceConnection {
    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected CommonActions commonActions;

    /**
     * Constructor.
     */
    public SalesForceConnection() {
        this.webDriver = DriverManager.getInstance().getNavigator();
        this.wait = DriverManager.getInstance().getWaiter();
        this.commonActions = new CommonActions();
        PageFactory.initElements(webDriver, this);
        waitUntilPageObjectIsLoaded();
    }

    public abstract void waitUntilPageObjectIsLoaded();
}
