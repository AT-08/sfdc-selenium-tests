package org.fundacionjala.sfdc.util;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {
    public static WebDriverWait waiter;
    public static WebElement getElement(WebElement element) {
        waiter = DriverManager.getInstance().getWaiter();
        waiter.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static void clickElement(WebElement element) {
        getElement(element).click();
    }


}
