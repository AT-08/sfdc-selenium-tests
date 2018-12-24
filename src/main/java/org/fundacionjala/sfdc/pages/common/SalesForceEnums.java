package org.fundacionjala.sfdc.pages.common;

import java.util.HashMap;

/**
 * SL enums for themes.
 */
public class SalesForceEnums {

    /**
     * Enum theme.
     */
    public enum Theme {
        CLASSIC("classic"),
        LIGHT("lightning");

        private String themeName;

        /**
         * Enum theme constructor.
         *
         * @param themeName is the theme name.
         */
        Theme(final String themeName) {
            this.themeName = themeName;
        }

        /**
         * Get the theme name.
         *
         * @return the theme name.
         */
        public String getThemeName() {
            return themeName;
        }

        private static final HashMap<String, Theme> THEME_HASH_MAP = new HashMap<>();

        static {
            for (Theme theme : values()) {
                THEME_HASH_MAP.put(theme.getThemeName(), theme);
            }
        }
    }

    /**
     * Enum theme.
     */
    public enum EnumLocator {
        ACCOUNT("account", "Accounts"),
        CONTACT("contact", "Contacts"),
        OPPORTUNITY("opportunity", "Opportunities"),
        CAMPAIGN("campaign", "Campaigns"),
        PRODUCT("product", "Products");

        private String locatorClassic;
        private String locatorLightning;

        /**
         * Enum constructor.
         *
         * @param locatorClassic   is the locator on classic theme.
         * @param locatorLightning is the locator on lightning.
         */
        EnumLocator(final String locatorClassic, final String locatorLightning) {
            this.locatorClassic = locatorClassic;
            this.locatorLightning = locatorLightning;
        }

        /**
         * Get the locator to classic theme.
         *
         * @return the locator on classic theme.
         */
        public String getLocatorClassic() {
            return locatorClassic;
        }

        /**
         * Get the locator to lightning theme.
         *
         * @return the locator on lightning theme.
         */
        public String getLocatorLightning() {
            return locatorLightning;
        }

    }
}
