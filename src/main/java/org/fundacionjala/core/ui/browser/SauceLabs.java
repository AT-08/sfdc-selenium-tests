package org.fundacionjala.core.ui.browser;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.fundacionjala.core.util.PropertiesInput;

/**
 * This class allows to establish the connection in the remote browser through SauceLabs.
 */
public class SauceLabs extends RemoteBrowser implements Browser {

    private static final String URL =
            String.format("http://%s:%s@ondemand.saucelabs.com:80/wd/hub", USERNAME, ACCESS_KEY);
    private static final String BROWSER_NAME = "browserName";
    private static final String PLATFORM = "platform";
    private static final String BROWSER_VERSION = "version";

    /**
     * This is the constructor.
     */
    public SauceLabs() {
        super(URL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DesiredCapabilities setCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(BROWSER_NAME, PROPERTIES.getProperties(PropertiesInput.REMOTE_BROWSER_NAME));
        capabilities.setCapability(PLATFORM, PROPERTIES.getProperties(PropertiesInput.REMOTE_PLATFORM));
        capabilities.setCapability(BROWSER_VERSION, PROPERTIES.getProperties(PropertiesInput.REMOTE_BROWSER_VERSION));
        capabilities.setCapability(RESOLUTION, PROPERTIES.getProperties(PropertiesInput.REMOTE_RESOLUTION));
        return capabilities;
    }
}
