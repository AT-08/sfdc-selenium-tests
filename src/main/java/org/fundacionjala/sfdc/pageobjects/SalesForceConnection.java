package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.openqa.selenium.WebDriver;

/**
 * SalesForceConnection.java
 * Class to initialize WebDriver for all pages.
 */
public class SalesForceConnection {
    protected WebDriver webDriver;

    /**
     * Constructor.
     */
    public SalesForceConnection() {
        this.webDriver = DriverManager.getInstance().getNavigator();
    }
}
