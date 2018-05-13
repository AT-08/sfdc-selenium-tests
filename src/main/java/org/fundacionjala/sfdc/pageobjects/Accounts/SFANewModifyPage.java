package org.fundacionjala.sfdc.pageobjects.Accounts;

import org.fundacionjala.sfdc.pageobjects.SalesForceConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * SFANewModifyPage.java
 * Class that represents the form where you fill fields in order to create or modify an account.
 */
public class SFANewModifyPage extends SalesForceConnection{
    private By accountNameTextField;
    private By parentAccountTextField;
    private By accountNumberTextField;
    private By accountSiteTextField;
    private By accountTypeList;
    private By typeList;
    private By industryList;
    private By annualRevenueTextField;
    private By ratingList;
    private By phoneTextField;
    private By faxTextField;
    private By websiteTextField;
    private By tickerSymbolTextField;
    private By ownershipList;
    private By employeesTextField;
    private By sicCodeTextField;

    private By billingStreetTextField;
    private By billingZipCodeTextField;
    private By billingCityTextField;
    private By billingStateTextField;
    private By billingCountryTextField;
    private By shippingStreetTextField;
    private By shippingZipCodeTextField;
    private By shippingCityTextField;
    private By shippingStateTextField;
    private By shippingCountryTextField;

    private By customerPriorityList;
    private By slaExpDateTextField;
    private By numLocationsTextField;
    private By activeList;
    private By slaList;
    private By slaSerialNumTextField;
    private By upsellOpList;

    private By descTextField;


    private By saveNewAccountButton;

    /**
     * Constructor.
     */
    public SFANewModifyPage() {
        super();
        this.accountNameTextField = By.cssSelector(".requiredInput > input[name='acc2']");
        this.parentAccountTextField = By.cssSelector(".lookupInput > input[name='acc3']");
        this.accountNumberTextField = By.id("#acc5");
        this.accountSiteTextField = By.id("#acc23");
        this.typeList = By.id("#acc6");
        this.industryList = By.id("#acc7");
        this.annualRevenueTextField = By.id("#acc8");

        this.ratingList = By.id("#acc9");
        this.phoneTextField = By.id("#acc10");
        this.faxTextField = By.id("#acc11");
        this.websiteTextField = By.id("#acc12");
        this.tickerSymbolTextField = By.id("#acc13");
        this.ownershipList = By.id("#acc14");
        this.employeesTextField = By.id("#acc15");
        this.sicCodeTextField = By.id("#acc16");

        this.saveNewAccountButton = By.cssSelector(".pbButton > input[name='save']");
    }

    /**
     * Getter of saveNewAccountButton.
     * @return button.
     */
    public WebElement getSaveNewAccountButton() {
        return this.webDriver.findElement(this.saveNewAccountButton);
    }

    /**
     * Method to set accountName attribute.
     * @param accountName string value.
     */
    public void setAccountNameTextField(final String accountName) {
        webDriver.findElement(this.accountNameTextField).sendKeys(accountName);
    }
    public void setParentAccountTextField(final String parentAccount) {
        webDriver.findElement(this.parentAccountTextField).sendKeys(parentAccount);
    }
    public void setAccountNumberTextField(final String accountNumber) {
        webDriver.findElement(this.accountNumberTextField).sendKeys(accountNumber);
    }
    public void setAccountSiteTextField(final String accountSite) {
        webDriver.findElement(this.accountSiteTextField).sendKeys(accountSite);
    }
    public void setAccountTypeList(final String type) {
        webDriver.findElement(this.typeList).sendKeys(type);
    }
    public void setIndustryList(final String industry) {
        webDriver.findElement(this.industryList).sendKeys(industry);
    }
    public void setAnnualRevenueTextField(final String annualRevenue) {
        webDriver.findElement(this.annualRevenueTextField).sendKeys(annualRevenue);
    }


    /**
     * Method to click button.
     */
    public void clickSaveNewAccountButton() {
        getSaveNewAccountButton().click();
    }
}
