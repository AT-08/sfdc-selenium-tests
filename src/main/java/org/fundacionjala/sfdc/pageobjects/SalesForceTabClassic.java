package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * SalesForceTabClassic.
 */
public class SalesForceTabClassic extends Base {

    @FindBy(how = How.ID, using = "Account_Tab")
    private WebElement accountTab;


    @FindBy(how = How.ID, using = "Contact_Tab")
    private WebElement contactTab;

    @FindBy(how = How.ID, using = "Opportunity_Tab")
    private WebElement opportunityTab;

    /**
     * setOpportunityTab.
     */
    public void setOpportunityTab() {
        CommonActions.clickElement(opportunityTab);
        closeMessageLighting();

    }

    /**
     * setContactTab.
     */
    public void setContactTab() {
        CommonActions.clickElement(contactTab);
        closeMessageLighting();
    }

    /**
     * setAccountTab.
     */
    public void setAccountTab() {
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

    /**
     * Wait until the page loads.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        System.out.println("Construction.");
    }
}
