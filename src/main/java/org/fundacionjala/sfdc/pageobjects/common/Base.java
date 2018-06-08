package org.fundacionjala.sfdc.pageobjects.common;

import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base.java
 * Class to initialize WebDriver for all pages.
 */
public abstract class Base {
    protected WebDriver webDriver;
    protected WebDriverWait driverWait;

    /**
     * Constructor.
     */
    public Base() {
        this.webDriver = DriverManager.getInstance().getDriver();
        driverWait = DriverManager.getInstance().getWaiter();
        PageFactory.initElements(this.webDriver, this);
    }
}
