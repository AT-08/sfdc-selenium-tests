package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * SalesForceTabClassic.
 */
public class SalesForceTabClassic extends Base {

    @FindAll({
            @FindBy(how = How.ID, using = "AllTab_Tab"),
            @FindBy(how = How.CSS, using = ".slds-icon-waffle .slds-r1")
    })
    private WebElement plusButton;

    @FindAll({
            @FindBy(how = How.CSS, using = "a.accountBlock"),
            @FindBy(how = How.CSS, using = ".oneAppLauncherItem a[title='Accounts']")
    })
    private WebElement accountTab;

    @FindAll({
            @FindBy(how = How.CSS, using = "a.contactBlock"),
            @FindBy(how = How.XPATH, using = ".oneAppLauncherItem a[title='Contacts']")
    })
    private WebElement contactTab;

    @FindAll({
            @FindBy(how = How.CSS, using = "a.opportunityBlock"),
            @FindBy(how = How.XPATH, using = ".oneAppLauncherItem a[title='opportunities']")
    })
    private WebElement opportunityTab;

    /**
     * setOpportunityTab.
     */
    public void setOpportunityTab() {
        CommonActions.clickElement(plusButton);
        CommonActions.clickElement(opportunityTab);
        closeMessageLighting();

    }

    /**
     * setContactTab.
     */
    public void setContactTab() {
        CommonActions.clickElement(plusButton);
        CommonActions.clickElement(contactTab);
        closeMessageLighting();
    }

    /**
     * setAccountTab.
     */
    public void setAccountTab() {
        CommonActions.clickElement(plusButton);
        CommonActions.clickElement(accountTab);
        closeMessageLighting();
    }

    /**
     * Method to close message displayed.
     */
    public void closeMessageLighting() {
        try {
            if (webDriver.findElement(By.id("lexNoThanks")).isDisplayed()) {
                webDriver.findElement(By.id("lexNoThanks")).click();
                webDriver.findElement(By.id("tryLexDialogX")).click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Message not displayed.");
        }
    }
}
