package org.fundacionjala.sfdc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalesForceOpportunitiesHome {
    private WebDriver driver;

    public SalesForceOpportunitiesHome(WebDriver driver) {
        this.driver = driver;
    }

    public SalesForceEditOpportunity clickNewOpportunity(){
        driver.findElement(By.name("new")).click();
        return new SalesForceEditOpportunity(driver);
    }

    public String getLastOpportunity(){
       return driver.findElement(By.cssSelector("tr.dataRow:nth-child(2) > th:nth-child(1) > a:nth-child(1)")).getText();
    }

    public SalesForceOpportunityPage editLastOpportunity(){
        driver.findElement(By.cssSelector("tr.dataRow:nth-child(2) > th:nth-child(1) > a:nth-child(1)")).click();
        return new SalesForceOpportunityPage(driver);
    }

    public SalesForceOpportunityPage deleteLastOpportunity(){
        driver.findElement(By.cssSelector("tr.dataRow:nth-child(2) > th:nth-child(1) > a:nth-child(1)")).click();
        return new SalesForceOpportunityPage(driver);
    }

}
