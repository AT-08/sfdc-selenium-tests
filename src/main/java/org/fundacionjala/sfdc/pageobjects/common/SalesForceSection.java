package org.fundacionjala.sfdc.pageobjects.common;

import org.fundacionjala.core.selenium.Base;
import org.fundacionjala.core.selenium.CommonWebActions;
import org.fundacionjala.sfdc.util.PropertiesSalesForce;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * SalesForceSection.
 */
public class SalesForceSection extends Base {

    private static final boolean IS_CLASSIC = PropertiesSalesForce.getInstance().getTheme().equalsIgnoreCase("classic");

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
            CommonWebActions.clickElement(plusButton);
        } else {
            CommonWebActions.waitTime(2);
            CommonWebActions.jsClickElement(plusButton);
        }
        CommonWebActions.jsClickByElementLocator(this.salesForceTabSelector(section));
        CommonWebActions.closeMessageLighting();
        CommonWebActions.resetWaitTime();
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
