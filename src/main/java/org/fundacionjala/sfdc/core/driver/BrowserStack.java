package org.fundacionjala.sfdc.core.driver;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * This class allows to establish the connection in the remote browser through Browser Stack.
 */
public class BrowserStack extends RemoteBrowserConnection implements Browser {
    private static final String URL =
            String.format("http://%s:%s@hub-cloud.browserstack.com/wd/hub", USERNAME, ACCESS_KEY);
    private static final String BROWSER = "browser";
    private static final String BROWSER_VERSION = "browser_version";
    private static final String OS = "os";
    private static final String OS_VERSION = "os_version";
    protected static final String RESOLUTION = "resolution";


    /**
     * This is the constructor.
     */
    public BrowserStack() {
        super(URL);
    }

    /**
     * @return.
     */
    @Override
    public DesiredCapabilities setCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(BROWSER, PROPERTIES_MANAGER.getRemoteBrowserName());
        capabilities.setCapability(BROWSER_VERSION, PROPERTIES_MANAGER.getRemoteBrowserVersion());
        capabilities.setCapability(OS, PROPERTIES_MANAGER.getRemoteOS());
        capabilities.setCapability(OS_VERSION, PROPERTIES_MANAGER.getRemoteOSVersion());
        capabilities.setCapability(RESOLUTION, PROPERTIES_MANAGER.getRemoteResolution());
        return capabilities;
    }
}
