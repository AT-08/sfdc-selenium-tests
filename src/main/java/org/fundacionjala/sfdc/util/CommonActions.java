package org.fundacionjala.sfdc.util;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * CommonActions.java
 * Class with common methods that many classes can use.
 */
public final class CommonActions {
    private static final WebDriverWait WAITER = DriverManager.getInstance().getWaiter();

    /**
     * Private constructor because it is a util class.
     */
    private CommonActions() {
    }

    /**
     * Method to get any element but wait until it is visible.
     *
     * @param element to wait for.
     * @return the element.
     */
    public static WebElement getElement(final WebElement element) {
        WAITER.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    /**
     * Method to click any element.
     *
     * @param element to click.
     */
    public static void clickElement(final WebElement element) {
        System.out.println("clicking "+element);
        WAITER.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }


    /**
     * Method to scroll down page.
     *
     * @param webDriver the webdriver.
     * @param element   the element we want to choose.
     */
    public static void scrollPage(final WebDriver webDriver, final WebElement element) {
        System.out.println("clicking scroll "+element);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

}
