package org.fundacionjala.sfdc.pageobjects.common;

import org.fundacionjala.core.common.Base;
import org.fundacionjala.core.util.PropertiesManager;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.core.util.CommonWebActions.*;

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
            clickElement(plusButton);
        } else {
            waitTime(2);
            jsClickElement(plusButton);
        }
        jsClickByElementLocator(this.salesForceTabSelector(section));
        closeMessageLighting();
        resetWaitTime();
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
