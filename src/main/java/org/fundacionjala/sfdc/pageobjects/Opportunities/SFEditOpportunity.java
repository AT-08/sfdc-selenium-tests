package org.fundacionjala.sfdc.pageobjects.Opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Edit Opportunity Page Object.
 */
public class SFEditOpportunity {
    private WebDriver driver;

    /**
     * Class constructor.
     * @param driver Selenium Webdriver.
     */
    public SFEditOpportunity(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method for create or edit an opportunity.
     * @param name the opportunity name.
     * @param closeDate close date.
     * @param stage the opportunity stage.
     */
    public void editOpportunity(String name, String closeDate, String stage) {
        driver.findElement(By.id("opp3")).sendKeys(name);
        driver.findElement(By.id("opp9")).clear();
        driver.findElement(By.id("opp9")).sendKeys(closeDate);
        driver.findElement(By.id("opp9")).sendKeys(Keys.ESCAPE);
        new Select(driver.findElement(By.id("opp11"))).selectByVisibleText(stage);
        driver.findElement(By.xpath("//option[@value='" + stage + "']")).click();
        driver.findElement(By.cssSelector("#topButtonRow > input:nth-child(1)")).click();
    }

    /**
     * This method leads to an Opportunity Home Page.
     * @return the Opportunities Home Page Object.
     */
    public SFOpportunitiesHome goToOpportunitiesPage(){
        driver.findElement(By.id("AllTab_Tab")).click();
        driver.findElement(By.linkText("Opportunities")).click();
        return new SFOpportunitiesHome(driver);
    }
}
