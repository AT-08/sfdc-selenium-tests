package org.fundacionjala.sfdc.core.e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Class to return the FirefoxDriver for Firefox browser.
 */
public class FirefoxBrowser implements Browser {

    /**
     * Get the Firefox driver.
     *
     * @return the FirefoxDriver.
     */
    @Override
    public WebDriver getBrowser() {
        return new FirefoxDriver();
    }
}
