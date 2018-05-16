package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.pageobjects.Home.HomePage;
import org.fundacionjala.sfdc.pageobjects.Home.HomePageClassic;
import org.fundacionjala.sfdc.pageobjects.Home.HomePageLightning;
import org.fundacionjala.sfdc.pageobjects.components.TopMenu;
import org.fundacionjala.sfdc.pageobjects.components.TopMenuClassic;
import org.fundacionjala.sfdc.pageobjects.components.TopMenuLightning;
import org.fundacionjala.sfdc.pageobjects.config.SalesForceAppEnvsConfig;

import static org.fundacionjala.sfdc.pageobjects.SalesForceEnums.Theme;

public class PageFactory {
    private static Theme theme = SalesForceAppEnvsConfig.getInstance().getTheme();

    public static HomePage getHomePage() {
        if (theme == Theme.CLASSIC) {
            return new HomePageClassic();
        } else {
            return new HomePageLightning();
        }
    }

    public static TopMenu getTopMenu() {
        if (theme == Theme.CLASSIC) {
            return new TopMenuClassic();
        } else {
            return new TopMenuLightning();
        }
    }

    public static TopMenu getTopMenu(Theme theme) {
        if (theme == Theme.CLASSIC) {
            return new TopMenuClassic();
        } else {
            return new TopMenuLightning();
        }
    }
}
