package org.fundacionjala.sfdc.commons;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * DriverManager.java.
 * Class that applies Singleton pattern to instance WebDriver only once.
 */
public final class DriverManager {
    private static DriverManager driverManager;
    private WebDriver driver;
    private WebDriverWait wait;
    private static final int SECONDS_WAIT = 50;

    /**
     * Constructor, private to apply singleton pattern.
     */
    private DriverManager() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, SECONDS_WAIT);
    }

    /**
     * Static method to get an class instance.
     *
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
     *
     * @return WebDriver instance.
     */
    public WebDriver getNavigator() {
        return driver;
    }

    /**
     * Getter of WebDriverWait object.
     *
     * @return WebDriverWait instance.
     */
    public WebDriverWait getWaiter() {
        return wait;
    }
}
