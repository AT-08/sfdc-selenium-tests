package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.pageobjects.components.TopMenu;
import org.fundacionjala.sfdc.pageobjects.components.TopMenuClassic;
import org.fundacionjala.sfdc.pageobjects.components.TopMenuLightning;
import org.fundacionjala.sfdc.pageobjects.config.SalesForceAppConfig;

import static org.fundacionjala.sfdc.pageobjects.SalesForceEnums.Theme;

/**
 * Page factory to return whether the page is classic or lightning.
 */
public final class PageFactory {

    /**
     * Constructor.
     */
    private PageFactory() {
    }

    private static Theme theme = SalesForceAppConfig.getInstance().getTheme();

    /**
     * Get whether is classic or lightning.
     *
     * @return instance whether is classic or lightning.
     */
    public static TopMenu getTopMenu() {
        if (theme == Theme.CLASSIC) {
            return new TopMenuClassic();
        } else {
            return new TopMenuLightning();
        }
    }

    /**
     * Get whether is classic or lightning.
     *
     * @param theme the theme.
     * @return instance whether is classic or lightning.
     */
    public static TopMenu getTopMenu(final Theme theme) {
        if (theme == Theme.CLASSIC) {
            return new TopMenuClassic();
        } else {
            return new TopMenuLightning();
        }
    }
}
