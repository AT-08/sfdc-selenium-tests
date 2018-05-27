package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * SalesForceSection.
 */
public class SalesForceSection extends Base {

    private static final boolean IS_CLASSIC = PropertiesManager.getInstance().getTheme().equalsIgnoreCase("classic");

    @FindAll({
            @FindBy(id = "AllTab_Tab"),
            @FindBy(xpath = "//div[@class='slds-icon-waffle']/parent::button")
    })
    private WebElement plusButton;

    /**
     * setSalesForceTab.
     *
     * @param section .
     */
    public void goToSalesForceTab(final SalesForceObject section) {
        CommonActions.clickElement(plusButton);
        CommonActions.clickByElementLocator(this.salesForceTabSelector(section.toString()));
        closeMessageLighting();
    }

    /**
     * @param section section on String format.
     * @return String, selector of tab created.
     */
    public String salesForceTabSelector(final String section) {

        String classicSelector = section.toLowerCase();
        String lightningSelector = String
                .format("%s%s", classicSelector.substring(0, 1).toUpperCase(), classicSelector.substring(1));

        if (IS_CLASSIC) {
            classicSelector = classicSelector.substring(0, classicSelector.length() - 1);
            if (classicSelector.equalsIgnoreCase("OPPORTUNITIE")) {
                classicSelector = "opportunity";
            }
            return String.format("a.%sBlock", classicSelector);
        }

        return String.format(".oneAppLauncherItem a[title='%s']", lightningSelector);
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
