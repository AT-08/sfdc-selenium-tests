package org.fundacionjala.sfdc.pageobjects.login;

import org.fundacionjala.sfdc.pageobjects.common.Base;
import org.fundacionjala.sfdc.pageobjects.common.PageUtil;
import org.fundacionjala.sfdc.pageobjects.components.TopMenuClassic;
import org.fundacionjala.sfdc.pageobjects.components.TopMenuLightning;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * SalesForceLogIn.java
 * Class to log in Salesforce.
 */
public class SalesForceLogIn extends Base {
    private String url;

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement userPassword;

    @FindBy(id = "Login")
    private WebElement logInButton;

    @FindAll({
            @FindBy(css = "img#phHeaderLogoImage"),
            @FindBy(css = "div.slds-global-header__logo")
    })
    private WebElement cloudIcon;


    private TopMenuClassic topMenuClassic = new TopMenuClassic();
    private TopMenuLightning topMenuLightning = new TopMenuLightning();

    /**
     * Constructor.
     *
     * @param url the page.
     */
    public SalesForceLogIn(final String url) {
        this.url = url;
    }

    /**
     * Setter of url attribute.
     */
    public void setWebDriverUrl() {
        this.webDriver.get(this.url);
    }

    /**
     * Setter of userName attribute.
     *
     * @param userName string value.
     */
    public void setUserName(final String userName) {
        CommonActions.getElement(this.userName).sendKeys(userName);
    }

    /**
     * Setter of userPassword attribute.
     *
     * @param userPassword string value.
     */
    public void setUserPassword(final String userPassword) {
        CommonActions.getElement(this.userPassword).sendKeys(userPassword);
    }

    /**
     * Set the user theme.
     *
     * @param userTheme the theme from properties.
     */
    public void setUserTheme(final String userTheme) {
        String currentTheme = PageUtil.getCurrentTheme().toString();
        if (!userTheme.equalsIgnoreCase(currentTheme)) {
            if (userTheme.equalsIgnoreCase("LIGHT")) {
                topMenuClassic.switchTheme();
            } else {
                topMenuLightning.switchTheme();
            }
        }
    }

    /**
     * Getter of logInbutton.
     *
     * @return the button.
     */
    public WebElement getLogInButton() {
        return CommonActions.getElement(this.logInButton);
    }

    /**
     * Method to click logInButton.
     *
     * @param button to click.
     */
    public void clickLogInButton(final WebElement button) {
        button.click();
    }

    /**
     * Method to log in Salesforce.
     *
     * @param user  the user.
     * @param pass  its password.
     * @param theme is the theme
     */
    public void logIn(final String user, final String pass, final String theme) {
        this.setWebDriverUrl();
        this.setUserName(user);
        this.setUserPassword(pass);
        WebElement button = getLogInButton();
        this.clickLogInButton(button);
        this.setUserTheme(theme);
    }

    /**
     * Method to lget icon cloud.
     *
     * @return if the icon is displayed
     */
    public boolean getCloudIcon() {
        return CommonActions.getElement(this.cloudIcon).isDisplayed();

    }
}
