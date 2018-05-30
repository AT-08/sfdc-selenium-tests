package org.fundacionjala.sfdc.util;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * CommonActions.java
 * Class with common methods that many classes can use.
 */
public final class CommonActions {

    private static final Actions ACTIONS = new Actions(DriverManager.getInstance().getNavigator());
    private static final WebDriverWait WAITER = DriverManager.getInstance().getWaiter();
    private static final WebDriver WEB_DRIVER = DriverManager.getInstance().getNavigator();
    private static final boolean IS_CLASSIC = PropertiesManager.getInstance().getTheme().equalsIgnoreCase("classic");
    private static final JavascriptExecutor JAVASCRIPT_EXECUTOR = (JavascriptExecutor) WEB_DRIVER;

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
     * This method generates a wait for a fixed time.
     *
     * @param time time.
     */
    public static void waitTime(int time) {
        DriverManager.getInstance().setUpdateWait(time);
    }

    /**
     * This method generates a wait for a fixed time.
     */
    public static void resetWaitTime() {
        DriverManager.getInstance().setUpdateWait(0);
    }

    /**
     * Method to click any element.
     *
     * @param element to click.
     */
    public static void clickElement(final WebElement element) {
        WAITER.until(ExpectedConditions.elementToBeClickable(element));
        WAITER.until(ExpectedConditions.visibilityOf(element));
        scrollPage(element);
        element.click();
    }

    /**
     * Method to JClick any element.
     *
     * @param element to click.
     */
    public static void jsClickElement(final WebElement element) {
        WAITER.until(ExpectedConditions.elementToBeClickable(element));
        JAVASCRIPT_EXECUTOR.executeScript("arguments[0].click();", element);
    }

    /**
     * Method to click any element.
     *
     * @param locator to click.
     */
    public static void jsClickByElementLocator(final String locator) {
        WAITER.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
        WAITER.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
        WebElement element = WEB_DRIVER.findElement(By.cssSelector(locator));
        scrollPage(element);
        jsClickElement(element);
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
     * @param element the element we want to choose.
     */
    public static void scrollPage(final WebElement element) {
        JAVASCRIPT_EXECUTOR.executeScript("arguments[0].scrollIntoView();", element);
        WAITER.until(ExpectedConditions.elementToBeClickable(element));
        ACTIONS.moveToElement(element);
    }

    /**
     * @param element Any WebElement.
     * @param text    set a text on a field.
     */
    public static void setTextElement(final WebElement element, final String text) {
        WAITER.until(ExpectedConditions.visibilityOf(element));
        clearTextField(element);
        element.sendKeys(text);
    }

    /**
     * @param element Any WebElement.
     * @param text    set a text on a field.
     */
    public static void setDateOnCalendar(final WebElement element, final String text) {
        setTextElement(element, text);
        element.sendKeys(Keys.TAB);
    }

    /**
     * @param element a checkbox element.
     * @param value   a boolean value.
     */
    public static void setCheckBox(final WebElement element, boolean value) {
        WAITER.until(ExpectedConditions.visibilityOf(element));
        if (!element.isSelected() && value) {
            clickElement(element);
        }
        if (element.isSelected() && !value) {
            clickElement(element);
        }
    }

    /**
     * Waits and clear the WebElement.
     *
     * @param element WebElement to wait and clear.
     */
    public static void clearTextField(final WebElement element) {
        WAITER.until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    /**
     * @param element        comboBox.
     * @param textOnComboBox select text on comboBox.
     */
    public static void selectOnComboBox(final WebElement element, final String textOnComboBox) {
        jsClickElement(element);
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
        String selector = String.format("//div[@title='%s']/parent::div/preceding-sibling::div", textToSelect);
        WAITER.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector)));
        clickElement(WEB_DRIVER.findElement(By.xpath(selector)));
    }

    /**
     * Updated upstream.
     *
     * @param element .
     * @return String .
     */
    public static String getConfirmMessageShowed(final WebElement element) {
        WAITER.until(ExpectedConditions.alertIsPresent());
        return element.getText();

    }

    /**
     * @param element        is the content parameter.
     * @param listOfElements list of elements.
     * @return WebElement .
     */
    public static boolean istWebElementPresentOnList(final List<WebElement> listOfElements,
                                                     final String element) {
        return listOfElements
                .stream()
                .anyMatch(elementOnList -> elementOnList.getText().equalsIgnoreCase(element));
    }

    /**
     * @param element        is the content parameter.
     * @param listOfElements list of elements.
     * @return WebElement .
     */
    public static WebElement getWebElementFromAList(final List<WebElement> listOfElements,
                                                    final String element) {
        return listOfElements
                .stream()
                .filter(elementOnList -> elementOnList.getText().equalsIgnoreCase(element))
                .findFirst()
                .orElseThrow(NullPointerException::new);

    }

    /**
     * Method to close message displayed.
     */
    public static void closeMessageLighting() {
        try {
            if (WEB_DRIVER.findElement(By.id("lexNoThanks")).isDisplayed()) {
                WEB_DRIVER.findElement(By.id("lexNoThanks")).click();
                WEB_DRIVER.findElement(By.id("tryLexDialogX")).click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method allows to format the contact name to compare with the assertion.
     *
     * @param contactName is the contact name.
     * @return the contact name formated .
     */
    public static String formatContactName(final String contactName) {
        if (!IS_CLASSIC) {
            String[] array = contactName.split(", ");
            if (array.length > 1) {
                return String.format("%s %s", array[1], array[0]);
            }
        }
        return contactName;
    }
}

