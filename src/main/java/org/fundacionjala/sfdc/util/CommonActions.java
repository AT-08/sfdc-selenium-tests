package org.fundacionjala.sfdc.util;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;


/**
 * CommonActions.java
 * Class with common methods that many classes can use.
 */
public final class CommonActions {
    private static final WebDriverWait WAITER = DriverManager.getInstance().getWaiter();
    private static final WebDriver WEB_DRIVER = DriverManager.getInstance().getNavigator();
    private static final boolean IS_CLASSIC = PropertiesManager.getInstance().getTheme().equalsIgnoreCase("classic");

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
        if (IS_CLASSIC) {
            scrollPage(WEB_DRIVER, element);
        }
        WAITER.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Method to click any element.
     *
     * @param locator to click.
     */
    public static void clickByElementLocator(final String locator) {

        WAITER.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
        WebElement element = WEB_DRIVER.findElement(By.cssSelector(locator));

        if (IS_CLASSIC) {
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
        String css = IS_CLASSIC
                ? String.format("option[value='%s']", textOnComboBox)
                : String.format("a[title='%s']", textOnComboBox);

        WEB_DRIVER.findElement(By.cssSelector(css)).click();
    }

    /**
     * @param element      auto completer textField.
     * @param textToSelect select text on autoCompleter.
     */
    public static void selectOnAutoCompleterTextField(final WebElement element, final String textToSelect) {

        if (IS_CLASSIC) {
            WEB_DRIVER.findElement(By.xpath("//input[contains(@id,'acc3')]/following-sibling::a")).click();

            autoCompleterClassicTheme(textToSelect);

        } else {
            element.click();
            autoCompleterLightTheme(textToSelect);
        }

    }

    /**
     * @param textToSelect select text on autoCompleter.
     */
    public static void autoCompleterClassicTheme(final String textToSelect) {

        Set<String> windowHandles = WEB_DRIVER.getWindowHandles();
        Iterator<String> iterate = windowHandles.iterator();
        String currentWindows = iterate.next();
        String secondWindows = iterate.next();

        WEB_DRIVER.switchTo().window(secondWindows);
        WEB_DRIVER.switchTo().frame("resultsFrame");

        String css = String.format("//a[text()='%s']", textToSelect);
        WAITER.until(ExpectedConditions.presenceOfElementLocated(By.xpath(css)));
        clickElement(WEB_DRIVER.findElement(By.xpath(css)));

        WEB_DRIVER.switchTo().window(currentWindows);
    }

    /**
     * @param textToSelect select text on autoCompleter.
     */
    public static void autoCompleterLightTheme(final String textToSelect) {

        String css = String.format("//a[@role='option']/descendant::div[text()='%s']", textToSelect);
        WAITER.until(ExpectedConditions.presenceOfElementLocated(By.xpath(css)));
        clickElement(WEB_DRIVER.findElement(By.xpath(css)));
    }
}
