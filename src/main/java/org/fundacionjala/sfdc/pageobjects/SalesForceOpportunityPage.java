package org.fundacionjala.sfdc.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class SalesForceOpportunityPage {
    private WebDriver driver;
    private boolean acceptNextAlert = true;

    public SalesForceOpportunityPage(WebDriver driver) {
        this.driver = driver;
    }

    public SalesForceEditOpportunity editOpportunity() {
        driver.findElement(By.name("edit")).click();
        return new SalesForceEditOpportunity(driver);
    }

    public void deleteOpportunity() {
        driver.findElement(By.name("del")).click();
        acceptNextAlert = true;
        closeAlertAndGetItsText();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr.dataRow:nth-child(2) > th:nth-child(1) > a:nth-child(1)")));
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
