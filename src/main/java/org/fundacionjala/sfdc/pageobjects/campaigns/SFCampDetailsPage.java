package org.fundacionjala.sfdc.pageobjects.campaigns;

import org.fundacionjala.sfdc.pageobjects.SFDetails;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * SFCampDetailsPage.
 */
public class SFCampDetailsPage extends SFDetails {
    @FindBy(css = "bodyCell h2.pageDescription")
    private WebElement opportunityLabel;

    /**
     * @return getOpportunityName.
     */
    public String getOpportunityName() {
        return CommonActions.getTextElement(this.opportunityLabel);
    }

    /**
     * getEditButton.
     */
    @Override
    public void getEditButton() {
        CommonActions.clickElement(this.editButton);
    }

    /**
     * getDeleteButton.
     */
    @Override
    public void getDeleteButton() {
        CommonActions.clickElement(this.deleteButton);
    }

    /**
     * clickDeleteAlert.
     */
    @Override
    public void clickDeleteAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    /**
     * @return getNewAccountSavedName.
     */
    @Override
    public String getNewAccountSavedName() {
        return CommonActions.getTextElement(this.newAccountLabel);
    }
}
