package org.fundacionjala.sfdc.pageobjects.accounts;

import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Value;
import org.fundacionjala.sfdc.pageobjects.SalesForceConnection;
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
public class SFANewModifyPage extends SalesForceConnection{
    private Map<String, Value> NEW_ACCOUNTS_FIELDS = new HashMap<>();

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

    @FindBy(how = How.ID, using = "acc9")
    private WebElement ratingList;

    @FindBy(how = How.ID, using = "acc10")
    private WebElement phoneTextField;

    @FindBy(how = How.ID, using = "acc11")
    private WebElement faxTextField;

    @FindBy(how = How.ID, using = "acc12")
    private WebElement websiteTextField;

    @FindBy(how = How.ID, using = "acc13")
    private WebElement tickerSymbolTextField;

    @FindBy(how = How.ID, using = "acc14")
    private WebElement ownershipList;

    @FindBy(how = How.ID, using = "acc15")
    private WebElement employeesTextField;

    @FindBy(how = How.ID, using = "acc16")
    private WebElement sicCodeTextField;

    @FindBy(how = How.CSS, using = ".pbButton > input[name='save']")
    private WebElement saveNewAccountButton;

    /**
     * Constructor.
     */
    public SFANewModifyPage() {
        super();
        PageFactory.initElements(this.webDriver, this);
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
    public void setParentAccountTextField(final String parentAccount) {
        this.parentAccountTextField.sendKeys(parentAccount);
    }
    public void setAccountNumberTextField(final String accountNumber) {
        this.accountNumberTextField.sendKeys(accountNumber);
    }
    public void setAccountSiteTextField(final String accountSite) {
        this.accountSiteTextField.sendKeys(accountSite);
    }
    public void setAccountTypeList(final String type) {
        this.typeList.sendKeys(type);
    }
    public void setIndustryList(final String industry) {
        this.industryList.sendKeys(industry);
    }
    public void setAnnualRevenueTextField(final String annualRevenue) {
        this.annualRevenueTextField.sendKeys(annualRevenue);
    }

    /**
     * Method to click button.
     */
    public void clickSaveNewAccountButton() {
        getSaveNewAccountButton().click();
    }

    public Map<String, Value> fillMethodsToFields() {
        NEW_ACCOUNTS_FIELDS.put("accountName", (String v) -> {setAccountNameTextField(v);});
        NEW_ACCOUNTS_FIELDS.put("parentAccount", (String v) -> {setParentAccountTextField(v);});
        NEW_ACCOUNTS_FIELDS.put("accountNumber", (String v) -> {setAccountNumberTextField(v);});
        NEW_ACCOUNTS_FIELDS.put("accountSite", (String v) -> {setAccountSiteTextField(v);});
        NEW_ACCOUNTS_FIELDS.put("type", (String v) -> {setAccountTypeList(v);});
        NEW_ACCOUNTS_FIELDS.put("industry", (String v) -> {setIndustryList(v);});
        NEW_ACCOUNTS_FIELDS.put("anuualRevenue", (String v) -> {setAnnualRevenueTextField(v);});
        return NEW_ACCOUNTS_FIELDS;
    }
}
