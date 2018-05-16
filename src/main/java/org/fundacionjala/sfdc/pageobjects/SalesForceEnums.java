package org.fundacionjala.sfdc.pageobjects;

import java.util.HashMap;

public class SalesForceEnums {

    public enum Theme {
        CLASSIC("classic"),
        LIGHT("lightning");

        private String themeName;

        private Theme(String themeName) {
            this.themeName = themeName;
        }

        public String getThemeName() {
            return themeName;
        }

        private static final HashMap<String, Theme> THEME_HASH_MAP = new HashMap<>();

        static {
            for (Theme theme : Theme.values()) {
                THEME_HASH_MAP.put(theme.getThemeName(), theme);
            }
        }

//        public static Theme getThemeEnumByThemeName(String themeName) {
//            return THEME_HASH_MAP.get(themeName);
//        }
    }

}
