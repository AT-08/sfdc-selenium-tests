package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.core.e2e.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base.java
 * Class to initialize WebDriver for all pages.
 */
public abstract class Base {
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    /**
     * Constructor.
     */
    public Base() {
        this.webDriver = DriverManager.getInstance().getNavigator();
        PageFactory.initElements(this.webDriver, this);
        wait = DriverManager.getInstance().getWaiter();
    }
}
