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

    @FindBy(how = How.CSS, using = "#AllTab_Tab")
    private WebElement plusButton;

    @FindBy(how = How.CSS, using = "#bodyCell  a.listRelatedObject.accountBlock.title")
    private WebElement accountTab;

    @FindBy(how = How.CSS, using = "#bodyCell  a.listRelatedObject.contactBlock.title")
    private WebElement contactTab;

    @FindBy(how = How.CSS, using = "#bodyCell  a.listRelatedObject.opportunityBlock.title")
    private WebElement opportunityTab;

    /**
     * setPlusButton.
     */
    public void setPlusButton() {
        CommonActions.clickElement(plusButton);
    }

    /**
     * setOpportunityTab.
     */
    public void setOpportunityTab() {
        this.setPlusButton();
        CommonActions.clickElement(opportunityTab);
        closeMessageLighting();

    }

    /**
     * setContactTab.
     */
    public void setContactTab() {
        this.setPlusButton();
        CommonActions.clickElement(contactTab);
        closeMessageLighting();
    }

    /**
     * setAccountTab.
     */
    public void setAccountTab() {
        this.setPlusButton();
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
