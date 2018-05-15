package org.fundacionjala.sfdc.pageobjects.opportunities;

import org.fundacionjala.sfdc.pageobjects.SalesForceConnection;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Class that represents the page where an opportunity could be edited or modified.
 */
public class SFOMainPage extends SalesForceConnection {
    private boolean acceptNextAlert = true;

    @FindBy(how = How.NAME, using = "edit")
    private WebElement editOpportunityButton;

    @FindBy(how = How.NAME, using = "del")
    private WebElement deleteOpportunityButton;

    @FindBy(how = How.CSS, using = "tr.dataRow:nth-child(2) > th:nth-child(1) > a:nth-child(1)")
    private WebElement lastOpportunity;

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
        CommonActions.getElement(this.lastOpportunity);
    }

    /**
     * Method for confirm the dialog emergent.
     *
     * @return alert.
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
