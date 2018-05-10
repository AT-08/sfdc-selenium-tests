package org.fundacionjala.sfdc.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.sfdc.commons.DriverManager;
import java.util.Iterator;
import java.util.List;

/**
 * SalesForceAccounts.java
 * Class that represents Accounts page in SalesForce.
 */
public class SalesForceContacts {
    private WebDriver webDriver;
    private By newAccountButton;
    private By contactNameTextField;
    private By saveNewAccountButton;
    private By newAccountLabel;
    private By newContactButton;
    private By accountsViewList;
    private By goButton;
    private WebDriverWait wait;

    /**
     * Constructor.
     * @param webDriver instance.
     */
    public SalesForceContacts(final WebDriver webDriver) {
        this.webDriver = webDriver;
        this.newAccountButton = By.cssSelector(".pbButton > input[title='New']");
        this.contactNameTextField = By.cssSelector("input[placeholder='First Name']");
        this.saveNewAccountButton = By.cssSelector(".pbButton > input[name='save']");
        this.newAccountLabel = By.className("topName");
        this.accountsViewList = By.id("fcf");
        this.goButton = By.cssSelector(".fBody > input[class='btn']");
        this.newContactButton = By.cssSelector("a[title='New']");
    }



    public void clickNewButton(final WebElement button) {
        button.click();
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.contactNameTextField));
    }

    public WebElement getNewButton() {
        return this.webDriver.findElement(this.newContactButton);
    }




}

