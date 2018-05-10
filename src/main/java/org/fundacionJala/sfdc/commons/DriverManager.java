package org.fundacionJala.sfdc.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * DriverManager.java.
 * Class that applies Singleton pattern to instance WebDriver only once.
 */
public final class DriverManager {
    private static DriverManager driverManager;
    private static WebDriver driver;

    /**
     * Constructor, private to apply singleton pattern.
     */
    private DriverManager() {
        init();
    }

    /**
     * Static method to get an class instance.
     * @return instance.
     */
    public static DriverManager getInstance() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    /**
     * Initialize WebDriver object.
     */
    private void init() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
    }

    /**
     * Getter of WebDriver object.
     * @return WebDriver instance.
     */
    public WebDriver getNavigator() {
        return driver;
    }

}
