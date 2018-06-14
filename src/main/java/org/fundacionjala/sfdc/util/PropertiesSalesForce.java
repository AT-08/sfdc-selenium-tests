package org.fundacionjala.sfdc.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PropertiesSalesForce.java.
 * Class that applies Singleton pattern to instance Properties only once.
 */
public final class PropertiesSalesForce {
    private static PropertiesSalesForce propertiesSalesForce;
    private Properties properties;
    private static final Logger LOGGER = LogManager.getLogger(PropertiesSalesForce.class);

    /**
     * Constructor, private to apply singleton pattern.
     */
    private PropertiesSalesForce() {
        init();
    }

    /**
     * Static method to get an class instance.
     *
     * @return instance.
     */
    public static PropertiesSalesForce getInstance() {
        if (propertiesSalesForce == null) {
            propertiesSalesForce = new PropertiesSalesForce();
        }
        return propertiesSalesForce;
    }

    /**
     * Initialize Properties object.
     */
    private void init() {
        properties = new Properties();
        try (InputStream input = new FileInputStream("gradle.properties")) {
            properties.load(input);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Gets Url Login.
     *
     * @param var variable obtained of gradle.properties.
     * @return the enviroment value.
     */
    private String getEnvValue(final String var) {
        String property = System.getProperty(var);
        return property == null ? properties.getProperty(var) : property;
    }

    /**
     * Getter of theme.
     *
     * @return String theme.
     */
    public String getTheme() {
        return getEnvValue("theme");
    }

}
