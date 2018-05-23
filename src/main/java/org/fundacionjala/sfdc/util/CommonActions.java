package org.fundacionjala.sfdc.util;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.openqa.selenium.By;
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
    private static final WebDriver WEB_DRIVER = DriverManager.getInstance().getNavigator();
    private static final String THEME = PropertiesManager.getInstance().getTheme();

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

        if (THEME.equalsIgnoreCase("classic")) {
            scrollPage(WEB_DRIVER, element);
        }
        WAITER.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


    /**
     * @param element Any WebElement.
     * @return the text of Webelement.
     */
    public static String getTextElement(final WebElement element) {
        WAITER.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    /**
     * Method to scroll down page.
     *
     * @param webDriver the webdriver.
     * @param element   the element we want to choose.
     */
    public static void scrollPage(final WebDriver webDriver, final WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * @param element Any WebElement.
     * @param text    set a text on a field.
     */
    public static void setTextElement(final WebElement element, final String text) {
        WAITER.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    /**
     * @param element        comboBox.
     * @param textOnComboBox select text on comboBox.
     */
    public static void selectOnComboBox(final WebElement element, final String textOnComboBox) {

        element.click();
        String css = THEME.equalsIgnoreCase("classic")
                ? String.format("option[value='%s']", textOnComboBox)
                : String.format("a[title='%s']", textOnComboBox);

        WEB_DRIVER.findElement(By.cssSelector(css)).click();
    }

    /**
     * @param element      auto completer textField.
     * @param textToSelect select text on comboBox.
     */
    public static void selectOnAutoCompleterTextField(final WebElement element, final String textToSelect) {

        element.click();
        String css = THEME.equalsIgnoreCase("classic")
                ? String.format("option[value='%s']", textToSelect)
                : String.format("div[title='%s']", textToSelect);

        clickElement(WEB_DRIVER.findElement(By.cssSelector(css)));
    }
}
