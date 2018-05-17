package org.fundacionjala.sfdc.pageobjects;

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
            for (Theme theme : Theme.values()) {
                THEME_HASH_MAP.put(theme.getThemeName(), theme);
            }
        }
    }
}
