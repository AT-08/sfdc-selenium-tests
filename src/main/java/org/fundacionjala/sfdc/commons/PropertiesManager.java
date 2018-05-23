package org.fundacionjala.sfdc.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PropertiesManager.java.
 * Class that applies Singleton pattern to instance Properties only once.
 */
public final class PropertiesManager {
    private static PropertiesManager propertiesManager;
    private Properties prop;


    /**
     * Constructor, private to apply singleton pattern.
     */
    private PropertiesManager() {
        init();
    }

    /**
     * Static method to get an class instance.
     * @return instance.
     */
    public static PropertiesManager getInstance() {
        if (propertiesManager == null) {
            propertiesManager = new PropertiesManager();
        }
        return propertiesManager;
    }

    /**
     * Initialize Properties object.
     */
    private void init() {
        prop = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Getter of Properties object.
     * @return Properties instance.
     */
    public Properties getConfig() {
        return prop;
    }

    /**
     * Getter of username.
     * @return String username.
     */
    public String getUsername() {
        return prop.getProperty("user");
    }

    /**
     * Getter of password.
     * @return String password.
     */
    public String getPassword() {
        return prop.getProperty("password");
    }

    /**
     * Getter of theme.
     * @return String theme.
     */
    public String getTheme() {
        return prop.getProperty("theme");
    }
}
