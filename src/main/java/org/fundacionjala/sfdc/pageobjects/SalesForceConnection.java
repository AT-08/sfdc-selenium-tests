package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * SalesForceConnection.java
 * Class to initialize WebDriver for all pages.
 */
public class SalesForceConnection {
    protected WebDriver webDriver;

    /**
     * Constructor.
     */
    public  SalesForceConnection() {
        this.webDriver = DriverManager.getInstance().getNavigator();
        PageFactory.initElements(this.webDriver, this);
    }
}
