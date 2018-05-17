package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.pageobjects.components.TopMenu;
import org.fundacionjala.sfdc.pageobjects.config.SalesForceAppConfig;
import org.openqa.selenium.WebDriver;

/**
 * Class page util.
 */
public class PageUtil {
    private static PageUtil instance;
    private WebDriver webDriver = DriverManager.getInstance().getNavigator();

    /**
     * Initializes page util.
     */
    protected PageUtil() {
        initialize();
    }

    /**
     * Get the instance.
     *
     * @return the instance.
     */
    public static PageUtil getInstance() {
        if (instance == null) {
            instance = new PageUtil();
        }
        return instance;
    }

    /**
     * Initializes.
     */
    private void initialize() {
    }

    /**
     * Get the current URL.
     *
     * @return the current URL.
     */
    public String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }

    /**
     * Get the current theme.
     *
     * @return the current theme.
     */
    public SalesForceEnums.Theme getCurrentTheme() {
        if (getCurrentURL().contains(SalesForceEnums.Theme.LIGHT.getThemeName())) {
            return SalesForceEnums.Theme.LIGHT;
        }
        return SalesForceEnums.Theme.CLASSIC;
    }

    /**
     * To perform the switch of themes.
     */
    public void switchTheme() {
        if (!getCurrentTheme().equals(SalesForceAppConfig.getInstance().getTheme())) {
            TopMenu topMenu = PageFactory.getTopMenu(getCurrentTheme());
            topMenu.switchTheme();
        }
    }
}
