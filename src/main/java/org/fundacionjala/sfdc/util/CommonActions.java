package org.fundacionjala.sfdc.util;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

/**
 * CommonActions.java
 * Class with common methods that many classes can use.
 */
public final class CommonActions {
    private static final WebDriverWait WAITER = DriverManager.getInstance().getWaiter();

    /**
     * Private constructor because it is a util class.
     */
    public CommonActions() {

    }

    /**
     * Method to get any element but wait until it is visible.
     * @param element to wait for.
     * @return the element.
     */
    public static WebElement getElement(final WebElement element) {
        WAITER.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    /**
     * Method to get any element but wait until it is visible.
     * @param element to wait for.
     * @return the element.
     */
    public static By getElement(final By element) {
        WAITER.until(ExpectedConditions.visibilityOfElementLocated(element));
        return element;
    }

    /**
     * Method to click any element.
     * @param element to click.
     */
    public static void clickElement(final WebElement element) {
        element.click();
    }


    /**
     * Method to scroll down page.
     * @param webDriver the webdriver.
     * @param element the element we want to choose.
     */
    public static void scrollPage(final WebDriver webDriver, final WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * Method to fill map with required values.
     * @param values data table from feature.
     * @param methods map with field and methods.
     */
    public static void setValues(final Map<String, String> values, final Map<String, Value> methods) {
        Map<String, Value> filledValues = new HashMap<>();
        for (String key : values.keySet()) {
            filledValues.put(key, methods.get(key));
        }
        filledValues.forEach((s, value) -> value.fillField(values.get(s)));
    }
}
