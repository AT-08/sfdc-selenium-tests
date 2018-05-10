package org.fundacionjala.sfdc.stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageObjects.SalesForceLogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.Properties;

/**
 * LogInSteps.java.
 * Class for steps logIn.feature.
 */
public class LogInSteps {
    private WebDriver web;
    private Properties prop;
    private SalesForceLogIn login;

    /**
     * Given step.
     */
    @Given("^Open the Firefox and launch the application$")
    public void openTheFirefoxAndLaunchTheApplication() {
        System.out.println("This Step open the Firefox and go to login page of the application.");
        web = DriverManager.getInstance().getNavigator();
        login = new SalesForceLogIn(web, "https://login.salesforce.com/");
    }

    /**
     * When step.
     */
    @When("^Enter the Username and Password$")
    public void enterTheUsernameAndPassword() {
        System.out.println("This step enter the Username and Password on the login page.");
        prop = PropertiesManager.getInstance().getConfig();
        login.logIn(prop.getProperty("user"), prop.getProperty("password"));
    }

    /**
     * Then step.
     */
    @Then("^login to the system$")
    public void resetTheCredential() {
        final int waitSeconds = 90;
        System.out.println("Click login.");
        WebDriverWait wait = new WebDriverWait(web, waitSeconds);
        final String locator = "//div[@class='slds-global-header__logo']";
        WebElement searchOnDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        Assert.assertTrue(searchOnDashboard.isDisplayed());
    }

    /**
     * Then step.
     */
    @Then("^login to the application$")
    public void loginToTheApplication() {
        final int waitSeconds = 90;
        System.out.println("Click login");
        WebDriverWait wait = new WebDriverWait(web, waitSeconds);
        final String locator = "phHeaderLogoImage";
        WebElement searchOnDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
        Assert.assertTrue(searchOnDashboard.isDisplayed());
    }
}
