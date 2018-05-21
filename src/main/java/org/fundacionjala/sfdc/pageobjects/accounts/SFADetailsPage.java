package org.fundacionjala.sfdc.pageobjects.accounts;

import org.fundacionjala.sfdc.pageobjects.SFDetails;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * SFADetailsPage.java
 * Class that represents the page where details of an account are displayed.
 */
public class SFADetailsPage extends SFDetails {

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

    /**
     * Wait until the page loads.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        System.out.println("Construction.");
    }
}
