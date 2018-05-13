package org.fundacionjala.sfdc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SalesForceEditOpportunity {
    private WebDriver driver;

    public SalesForceEditOpportunity(WebDriver driver) {
        this.driver = driver;
    }

    public void editOpportunity(String name, String closeDate, String stage) {
        driver.findElement(By.id("opp3")).sendKeys(name);
        driver.findElement(By.id("opp9")).clear();
        driver.findElement(By.id("opp9")).sendKeys(closeDate);
        driver.findElement(By.id("opp9")).sendKeys(Keys.ESCAPE);
        new Select(driver.findElement(By.id("opp11"))).selectByVisibleText(stage);
        driver.findElement(By.xpath("//option[@value='" + stage + "']")).click();
        driver.findElement(By.cssSelector("#topButtonRow > input:nth-child(1)")).click();
    }

    public SalesForceOpportunitiesHome goToOpportunitiesPage(){
        driver.findElement(By.id("AllTab_Tab")).click();
        driver.findElement(By.linkText("Opportunities")).click();
        return new SalesForceOpportunitiesHome(driver);
    }
}
