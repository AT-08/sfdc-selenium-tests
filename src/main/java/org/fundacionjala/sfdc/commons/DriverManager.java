package org.fundacionjala.sfdc.commons;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * DriverManager.java.
 * Class that applies Singleton pattern to instance WebDriver only once.
 */
public final class DriverManager {
    private static DriverManager driverManager;
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final int SECONDS_WAIT = 360;

    /**
     * Constructor, private to apply singleton pattern.
     */
    private DriverManager() {
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
     * Getter of WebDriver object.
     * @return WebDriver instance.
     */
    public static WebDriver getNavigator() {
        if (driver == null || driver.getTitle().contains("null")) {
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            driver = new FirefoxDriver();
            return driver;
        }
        return driver;
    }
    /**
     * Getter of WebDriverWait object.
     * @return WebDriverWait instance.
     */
    public static WebDriverWait getWaiter() {
        if (wait == null) {
            wait = new WebDriverWait(driver, SECONDS_WAIT);
            return wait;
        }
        return wait;
    }

}
