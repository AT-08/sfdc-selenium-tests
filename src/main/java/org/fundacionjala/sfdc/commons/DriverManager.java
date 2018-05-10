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
    private static final int SECONDS_WAIT = 90;

    /**
     * Constructor, private to apply singleton pattern.
     */
    private DriverManager() {
        initWebDriver();
        initWebDriverWaiter();
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
    private void initWebDriver() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();
    }

    /**
     * Initialize WebDriverWaiter object.
     */
    private void initWebDriverWaiter() {
        wait = new WebDriverWait(this.driver, SECONDS_WAIT);
    }

    /**
     * Getter of WebDriver object.
     * @return WebDriver instance.
     */
    public WebDriver getNavigator() {
        return driver;
    }

    public WebDriverWait getWaiter() {
        return wait;
    }

}
