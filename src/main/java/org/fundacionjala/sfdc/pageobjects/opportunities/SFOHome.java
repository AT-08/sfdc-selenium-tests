package org.fundacionjala.sfdc.pageobjects.opportunities;

import org.fundacionjala.sfdc.pageobjects.SalesForceConnection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * SFOHome.java
 * Class that represents the opportunities Home Page.
 */
public class SFOHome extends SalesForceConnection {

    @FindBy(how = How.NAME, using = "new")
    private WebElement newOpportunityButton;

    @FindBy(how = How.CSS, using = "tr.dataRow:nth-child(2) > th:nth-child(1) > a:nth-child(1)")
    private WebElement lastOpportunity;

    /**
     * Method for click on new opportunity button.
     */
    public void clickNewOpportunity() {
        this.newOpportunityButton.click();
    }

    /**
     * @return the name of the last opportunity created.
     */
    public String getLastOpportunity() {
        return lastOpportunity.getText();
    }

    /**
     * This method allows to go to the last opportunity page.
     */
    public void goToLastOpportunityPage() {
        this.lastOpportunity.click();
    }
}
