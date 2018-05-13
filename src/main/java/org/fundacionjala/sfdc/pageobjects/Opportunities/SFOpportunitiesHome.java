package org.fundacionjala.sfdc.pageobjects.Opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Opportunities Home Page Object.
 */
public class SFOpportunitiesHome {
    private WebDriver driver;

    /**
     * Class constructor.
     * @param driver the Selenium webdriver.
     */
    public SFOpportunitiesHome(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method for click on new opportunity button.
     * @return an form for editing the opportunity selected.
     */
    public SFEditOpportunity clickNewOpportunity(){
        driver.findElement(By.name("new")).click();
        return new SFEditOpportunity(driver);
    }

    /**
     * @return the name of the last opportunity created.
     */
    public String getLastOpportunity(){
       return driver.findElement(By.cssSelector("tr.dataRow:nth-child(2) > th:nth-child(1) > a:nth-child(1)")).getText();
    }

    /**
     * This method allows to edit the last opportunity created.
     * @return a Page Object of the Edit Opportunity form.
     */
    public SFOpportunityPage editLastOpportunity(){
        driver.findElement(By.cssSelector("tr.dataRow:nth-child(2) > th:nth-child(1) > a:nth-child(1)")).click();
        return new SFOpportunityPage(driver);
    }

    /**
     * This method allows to delete the last opportunity created.
     * @return the page of the opportunity to be deleted.
     */
    public SFOpportunityPage deleteLastOpportunity(){
        driver.findElement(By.cssSelector("tr.dataRow:nth-child(2) > th:nth-child(1) > a:nth-child(1)")).click();
        return new SFOpportunityPage(driver);
    }

}
