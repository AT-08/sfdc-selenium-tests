package org.fundacionjala.sfdc.pageobjects.accounts;

import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.SFDetails;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * SFADetailsPage.java
 * Class that represents the page where details of an account are displayed.
 */
public class SFADetailsPage extends SFDetails {

    private static final boolean IS_CLASSIC = PropertiesManager.getInstance().getTheme().equalsIgnoreCase("classic");


    /**
     * clickEditButton.
     */
    @Override
    public void clickEditButton() {
        if (IS_CLASSIC) {
            CommonActions.clickElement(this.editButton);
        } else {
            CommonActions.clickByElementLocator("a[title='Show 7 more actions']");
            CommonActions.clickElement(this.editButton);
        }

    }

    /**
     * clickDeleteButton.
     */
    @Override
    public void clickDeleteButton() {
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
