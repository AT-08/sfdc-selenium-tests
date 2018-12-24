package org.fundacionjala.core.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.core.ui.driver.DriverManager;

/**
 * Class Base.
 */
public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverAction action;

    /**
     * Method for Base for declared DriverManager.
     */
    public Base() {
        driver = DriverManager.getInstance().getDriver();
        wait = DriverManager.getInstance().getWaiter();
        action = new WebDriverAction(driver, wait);
        PageFactory.initElements(driver, this);
    }
}
