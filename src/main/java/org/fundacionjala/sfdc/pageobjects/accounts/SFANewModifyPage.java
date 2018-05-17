package org.fundacionjala.sfdc.pageobjects.accounts;

import org.fundacionjala.sfdc.pageobjects.BasePage;
import org.fundacionjala.sfdc.pageobjects.HomeBasePage;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Value;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * SFANewModifyPage.java
 * Class that represents the form where you fill fields in order to create or modify an account.
 */
public class SFANewModifyPage extends HomeBasePage {
    private Map<String, Value> newAccountsFields = new HashMap<>();

    @FindBy(how = How.CSS, using = ".requiredInput > input[name='acc2']")
    private WebElement accountNameTextField;

    @FindBy(how = How.CSS, using = ".lookupInput > input[name='acc3']")
    private WebElement parentAccountTextField;

    @FindBy(how = How.ID, using = "acc5")
    private WebElement accountNumberTextField;

    @FindBy(how = How.ID, using = "acc23")
    private WebElement accountSiteTextField;

    @FindBy(how = How.ID, using = "acc6")
    private WebElement typeList;

    @FindBy(how = How.ID, using = "acc7")
    private WebElement industryList;

    @FindBy(how = How.ID, using = "acc8")
    private WebElement annualRevenueTextField;

    @FindBy(how = How.CSS, using = ".pbButton > input[name='save']")
    private WebElement saveNewAccountButton;

    /**
     * Constructor.
     */
    public SFANewModifyPage() {
        super();
        PageFactory.initElements(this.webDriver, this);
    }
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
    /**
     * Getter of saveNewAccountButton.
     * @return button.
     */
    public WebElement getSaveNewAccountButton() {
        return CommonActions.getElement(this.saveNewAccountButton);
    }

    /**
     * Method to set accountName attribute.
     * @param accountName string value.
     */
    public void setAccountNameTextField(final String accountName) {
        this.accountNameTextField.sendKeys(accountName);
    }

    /**
     * Method to set parentAccount attribute.
     * @param parentAccount the value.
     */
    public void setParentAccountTextField(final String parentAccount) {
        this.parentAccountTextField.sendKeys(parentAccount);
    }

    /**
     * Method to set accountNumber attribute.
     * @param accountNumber the value.
     */
    public void setAccountNumberTextField(final String accountNumber) {
        this.accountNumberTextField.sendKeys(accountNumber);
    }

    /**
     * Method to set accountSite attribute.
     * @param accountSite the value.
     */
    public void setAccountSiteTextField(final String accountSite) {
        this.accountSiteTextField.sendKeys(accountSite);
    }

    /**
     * Method to set type attribute.
     * @param type the value.
     */
    public void setAccountTypeList(final String type) {
        this.typeList.sendKeys(type);
    }

    /**
     * Method to set industry attribute.
     * @param industry the value.
     */
    public void setIndustryList(final String industry) {
        this.industryList.sendKeys(industry);
    }

    /**
     * Method to set annualRevenue attribute.
     * @param annualRevenue the value.
     */
    public void setAnnualRevenueTextField(final String annualRevenue) {
        this.annualRevenueTextField.sendKeys(annualRevenue);
    }



    /**
     * Method to click button.
     */
    public void clickSaveNewAccountButton() {
        getSaveNewAccountButton().click();
    }

    /**
     * Method to fill map with field name and method to set it.
     * @return the map.
     */
    public Map<String, Value> fillMethodsToFields() {
        newAccountsFields.put("accountName", this::setAccountNameTextField);
        newAccountsFields.put("parentAccount", this::setParentAccountTextField);
        newAccountsFields.put("accountNumber", this::setAccountNumberTextField);
        newAccountsFields.put("accountSite", this::setAccountSiteTextField);
        newAccountsFields.put("type", this::setAccountTypeList);
        newAccountsFields.put("industry", this::setIndustryList);
        newAccountsFields.put("anuualRevenue", this::setAnnualRevenueTextField);
        return newAccountsFields;
    }
}
