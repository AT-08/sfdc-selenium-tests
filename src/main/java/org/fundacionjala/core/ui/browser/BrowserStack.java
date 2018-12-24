package org.fundacionjala.core.ui.browser;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.fundacionjala.core.util.PropertiesInput;

/**
 * This class allows to establish the connection in the remote browser through Browser Stack.
 */
public class BrowserStack extends RemoteBrowser implements Browser {
    private static final String URL =
            String.format("http://%s:%s@hub-cloud.browserstack.com/wd/hub", USERNAME, ACCESS_KEY);
    private static final String BROWSER = "browser";
    private static final String BROWSER_VERSION = "browser_version";
    private static final String OS = "os";
    private static final String OS_VERSION = "os_version";

    /**
     * This is the constructor.
     */
    public BrowserStack() {
        super(URL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DesiredCapabilities setCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(BROWSER, PROPERTIES.getProperties(PropertiesInput.REMOTE_BROWSER_NAME));
        capabilities.setCapability(BROWSER_VERSION, PROPERTIES.getProperties(PropertiesInput.REMOTE_BROWSER_VERSION));
        capabilities.setCapability(OS, PROPERTIES.getProperties(PropertiesInput.REMOTE_OS));
        capabilities.setCapability(OS_VERSION, PROPERTIES.getProperties(PropertiesInput.REMOTE_OS_VERSION));
        capabilities.setCapability(RESOLUTION, PROPERTIES.getProperties(PropertiesInput.REMOTE_RESOLUTION));
        return capabilities;
    }
}
