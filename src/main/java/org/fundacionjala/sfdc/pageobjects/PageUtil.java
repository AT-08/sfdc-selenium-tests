package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.pageobjects.components.TopMenu;
import org.fundacionjala.sfdc.pageobjects.config.SalesForceAppEnvsConfig;
import org.openqa.selenium.WebDriver;

public class PageUtil {
    private static PageUtil instance;
    private WebDriver webDriver = DriverManager.getInstance().getWebDriver();

    protected PageUtil() {
        initialize();
    }

    public static PageUtil getInstance() {
        if (instance == null) {
            instance = new PageUtil();
        }
        return instance;
    }

    private void initialize() {
    }

    public String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }

    public SalesForceEnums.Theme getCurrentSkin() {
        if (getCurrentURL().contains(SalesForceEnums.Theme.LIGHT.getThemeName())) {
            return SalesForceEnums.Theme.LIGHT;
        }
        return SalesForceEnums.Theme.CLASSIC;
    }

    public void switchTheme() {
        if (!getCurrentSkin().equals(SalesForceAppEnvsConfig.getInstance().getTheme())) {
            TopMenu topMenu = PageFactory.getTopMenu(getCurrentSkin());
            topMenu.switchTheme();
        }
    }
}
