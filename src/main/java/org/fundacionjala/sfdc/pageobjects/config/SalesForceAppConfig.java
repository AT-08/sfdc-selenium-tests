package org.fundacionjala.sfdc.pageobjects.config;

import org.fundacionjala.sfdc.pageobjects.SalesForceEnums;

/**
 * Config of SL web application.
 */
public class SalesForceAppConfig {
    private static SalesForceAppConfig instance;

    /**
     * Singleton for getting the instance.
     *
     * @return the instance.
     */
    public static SalesForceAppConfig getInstance() {
        if (instance == null) {
            instance = new SalesForceAppConfig();
        }
        return instance;
    }

    private SalesForceEnums.Theme theme;

    /**
     * Get the theme.
     *
     * @return the theme.
     */
    public SalesForceEnums.Theme getTheme() {
        return theme;
    }

    /**
     * Set theme.
     *
     * @param theme to set.
     */
    public void setTheme(final SalesForceEnums.Theme theme) {
        this.theme = theme;
    }
}
