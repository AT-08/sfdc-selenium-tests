package org.fundacionjala.sfdc.util;

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
     *
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
            throw new RunTimeExceptions(e.getMessage(), e);
        }
    }

    /**
     * Getter of username.
     *
     * @return String username.
     */
    public String getUsername() {
        return prop.getProperty("user");
    }

    /**
     * Getter of password.
     *
     * @return String password.
     */
    public String getPassword() {
        return prop.getProperty("password");
    }

    /**
     * Getter of theme.
     *
     * @return String theme.
     */
    public String getTheme() {
        return prop.getProperty("theme");
    }

    /**
     * Gets browser.
     *
     * @return string browser.
     */
    public String getBrowser() {
        return prop.getProperty("browser");
    }

    /**
     * Getter of docker.
     *
     * @return string docker URL.
     */
    public String getDockerUrl() {
        return prop.getProperty("dockerURL");
    }

    /**
     * Gets remote user name.
     *
     * @return string remote user name.
     */
    public String getRemoteUserName() {
        return prop.getProperty("remoteUserName");
    }

    /**
     * Gets remote access key.
     *
     * @return string remote access key.
     */
    public String getRemoteAccessKey() {
        return prop.getProperty("remoteAccessKey");
    }

    /**
     * Gets remote Browser Name .
     *
     * @return string remote Browser Name.
     */
    public String getRemoteBrowserName() {
        return prop.getProperty("remoteBrowserName");
    }

    /**
     * Gets remote Version.
     *
     * @return string remote Version.
     */
    public String getRemoteBrowserVersion() {
        return prop.getProperty("remoteBrowserVersion");
    }

    /**
     * Gets remote platform.
     *
     * @return string remote platform.
     */
    public String getRemotePlatform() {
        return prop.getProperty("remotePlatform");
    }

    /**
     * Gets remote Resolution.
     *
     * @return string remote Resolution.
     */
    public String getRemoteResolution() {
        return prop.getProperty("remoteResolution");
    }

    /**
     * Gets remote operative system.
     *
     * @return string remote operative system.
     */
    public String getRemoteOS() {
        return prop.getProperty("remoteOS");
    }

    /**
     * Gets remote operative system.
     *
     * @return string remote operative system.
     */
    public String getRemoteOSVersion() {
        return prop.getProperty("remoteOSVersion");
    }

    /**
     * Gets the explicit time.
     *
     * @return the explicit time.
     */
    public int getExplicitTime() {
        return Integer.parseInt(prop.getProperty("explicitTime"));
    }

    /**
     * Gets the implicit time.
     *
     * @return the implicit time.
     */
    public int getImplicitTime() {
        return Integer.parseInt(prop.getProperty("implicitTime"));
    }
}
