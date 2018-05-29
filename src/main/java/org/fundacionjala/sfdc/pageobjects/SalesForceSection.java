package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.util.CommonActions;
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
            @FindBy(className = "slds-icon-waffle")
    })
    private WebElement plusButton;

    /**
     * setSalesForceTab.
     *
     * @param section .
     */
    public void goToSalesForceTab(final SalesForceEnums.EnumLocator section) {
        if (IS_CLASSIC) {
            CommonActions.clickElement(plusButton);
        } else {
            CommonActions.waitTime(2);
            CommonActions.jsClickElement(plusButton);
        }
        CommonActions.jsClickByElementLocator(this.salesForceTabSelector(section));
        CommonActions.closeMessageLighting();
        CommonActions.resetWaitTime();
    }

    /**
     * @param section section on String format.
     * @return String, selector of tab created.
     */
    public String salesForceTabSelector(final SalesForceEnums.EnumLocator section) {
        return IS_CLASSIC
                ? String.format("a.%sBlock", section.getLocatorClassic())
                : String.format("a[title=%s]>span>span", section.getLocatorLightning());
    }


}
