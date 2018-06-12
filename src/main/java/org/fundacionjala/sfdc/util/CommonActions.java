package org.fundacionjala.sfdc.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.core.driver.DriverManager;
import org.fundacionjala.core.util.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.common.SalesForceEnums;
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

import static org.fundacionjala.core.util.CommonWebActions.*;


/**
 * CommonActions.java
 * Class with common methods that many classes can use.
 */
public final class CommonActions {

    private static final WebDriverWait WAITER = DriverManager.getInstance().getWaiter();
    private static final WebDriver WEB_DRIVER = DriverManager.getInstance().getDriver();
    private static final boolean IS_CLASSIC = PropertiesManager.getInstance().getTheme().equalsIgnoreCase("classic");

    /**
     * Private constructor because it is a util class.
     */
    private CommonActions() {
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

    /**
     * This method allows to get the object name
     * and if is a contact return the object name formated.
     *
     * @param nameOfObject is the object name.
     * @param section      enum.
     * @return the contact name formated .
     */
    public static String getNameOfObject(final String nameOfObject, final SalesForceEnums.EnumLocator section) {
        return SalesForceEnums.EnumLocator.CONTACT.equals(section) ? formatContactName(nameOfObject) : nameOfObject;
    }
}

