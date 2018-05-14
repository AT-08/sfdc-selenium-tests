package org.fundacionjala.sfdc.util;

import org.fundacionjala.sfdc.Value;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

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

    public static void setValues(Map<String, String> fieldsAndValues, Map<String, Value> fieldsWithMethods) {
        Map<String, Value> filledValues = new HashMap<>();
        for (String key : fieldsAndValues.keySet()) {
            filledValues.put(key, fieldsWithMethods.get(key));
        }
        filledValues.forEach((s, value) -> value.fillField(fieldsAndValues.get(s)));
    }


}
