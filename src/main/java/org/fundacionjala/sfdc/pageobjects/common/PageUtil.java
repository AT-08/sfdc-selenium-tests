package org.fundacionjala.sfdc.pageobjects.common;

import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.openqa.selenium.WebDriver;

/**
 * Class page util.
 */
public final class PageUtil {

    private static WebDriver webDriver = DriverManager.getInstance().getNavigator();

    /**
     * Constructor.
     */
    private PageUtil() {
    }

    /**
     * Get the current URL.
     *
     * @return the current URL.
     */
    public static String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }

    /**
     * Get the current theme.
     *
     * @return the current theme.
     */
    public static SalesForceEnums.Theme getCurrentTheme() {
        return getCurrentURL().contains(SalesForceEnums.Theme.LIGHT.getThemeName())
                ? SalesForceEnums.Theme.LIGHT : SalesForceEnums.Theme.CLASSIC;
    }
}
