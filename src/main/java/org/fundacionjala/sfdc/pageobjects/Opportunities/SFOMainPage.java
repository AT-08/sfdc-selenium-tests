package org.fundacionjala.sfdc.pageobjects.Opportunities;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceConnection;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class that represents the page where an opportunity could be edited or modified.
 */
public class SFOMainPage extends SalesForceConnection {
    private boolean acceptNextAlert = true;
    private WebDriverWait wait;

    @FindBy(how = How.NAME, using = "edit")
    private WebElement editOpportunityButton;

    @FindBy(how = How.NAME, using = "del")
    private WebElement deleteOpportunityButton;

    @FindBy(how = How.CSS, using = "tr.dataRow:nth-child(2) > th:nth-child(1) > a:nth-child(1)")
    private WebElement lastOpportunity;

    /**
     * Constructor.
     */
    public SFOMainPage() {
        super();
        PageFactory.initElements(this.webDriver, this);
    }

    /**
     * Method for click on edit button.
     */
    public void clickEditOpportunity() {
        this.editOpportunityButton.click();

    }

    /**
     * Method for click on delete button.
     */

    public void clickDeleteOpportunity() {
        this.deleteOpportunityButton.click();
    }

    /**
     * Method that deletes the last opportunity created.
     */
    public void deleteOpportunity() {
        clickDeleteOpportunity();
        acceptNextAlert = true;
        closeAlertAndGetItsText();
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOf(this.lastOpportunity));
    }

    /**
     * Method for confirm the dialog emergent.
     */
    private String closeAlertAndGetItsText() {
        try {
            Alert alert = webDriver.switchTo().alert();
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
