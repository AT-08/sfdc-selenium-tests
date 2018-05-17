package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.pageobjects.Home.HomePage;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * SalesForceLogIn.java
 * Class to log in Salesforce.
 */
public class SalesForceLogIn extends BasePage {
    private String url;

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement userPassword;

    @FindBy(id = "Login")
    private WebElement logInButton;

    /**
     * Constructor.
     *
     * @param url the page.
     */
    public SalesForceLogIn(final String url) {
        super();
        this.url = url;
        PageFactory.initElements(this.webDriver, this);
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
     * @param user the user.
     * @param pass its password.
     */
    public HomePage logIn(final String user, final String pass) {
//        setWebDriverUrl();
        this.setUserName(user);
        this.setUserPassword(pass);
        WebElement button = getLogInButton();
        clickLogInButton(button);
        wait.until(ExpectedConditions.urlContains("home"));
        PageUtil.getInstance().switchTheme();
        return org.fundacionjala.sfdc.pageobjects.PageFactory.getHomePage();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.urlContains("login"));
    }
}
