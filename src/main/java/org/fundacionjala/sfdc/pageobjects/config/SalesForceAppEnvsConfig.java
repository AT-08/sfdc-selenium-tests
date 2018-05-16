package org.fundacionjala.sfdc.pageobjects.config;

import org.fundacionjala.sfdc.pageobjects.SalesForceEnums;

public class SalesForceAppEnvsConfig {
    private static SalesForceAppEnvsConfig instance;

    public static SalesForceAppEnvsConfig getInstance() {
        if (instance == null) {
            instance = new SalesForceAppEnvsConfig();
        }
        return instance;
    }

    private SalesForceEnums.Theme theme;

    public SalesForceEnums.Theme getTheme() {
        return theme;
    }
}
